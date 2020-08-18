package com.HospitalDemo.HospitalDemo.records;
import com.HospitalDemo.HospitalDemo.Service.PatientDataService;

import java.sql.*;

public class RowInsert {
    private static final String SQL_INSERT = "INSERT INTO PATIENTS (p_id,first_name,last_name,dob,age,height,weight,facility) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    public static void main(String[] args) {
        PatientDataService PatientDataService ;

        try (Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://127.0.0.1:5432/postgres", "postgres", "mano");
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_INSERT)) {

            preparedStatement.setInt(1, 2);
            preparedStatement.setString(2, "manikanta");
            preparedStatement.setString(3, "chaluvadi");
            preparedStatement.setDate(4, Date.valueOf("1999-08-06"));
            preparedStatement.setInt(5, 5);
            preparedStatement.setInt(6, 11);
            preparedStatement.setInt(7, 60);
            preparedStatement.setString(8,"Noo" );

            int row = preparedStatement.executeUpdate();

            // rows affected
            System.out.println(row); // 1

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
