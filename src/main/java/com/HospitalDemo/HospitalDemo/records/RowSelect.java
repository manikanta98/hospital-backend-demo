package com.HospitalDemo.HospitalDemo.records;

import java.sql.*;

public class RowSelect {
    private static final String SQL_SELECT = "SELECT * FROM PATIENTS";

    public static void main(String[] args) {

        try (Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://127.0.0.1:5432/postgres", "postgres", "mano");
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT)) {

            ResultSet resultSet = preparedStatement.executeQuery();
//            System.out.println("Resultset :" +resultSet);

            while (resultSet.next()) {

                System.out.println("Resultset :" +resultSet);


                long id = resultSet.getLong("p_id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                Date dob = resultSet.getDate("dob");
                int age = resultSet.getInt("age");
                int height = resultSet.getInt("height");
                int weight = resultSet.getInt("weight");
                String facility = resultSet.getString("facility");
                System.out.println(id);
                System.out.println(firstName);
                System.out.println(lastName);
                System.out.println(dob);
                System.out.println(age);
                System.out.println(height);
                System.out.println(weight);
                System.out.println(facility);

            }


        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
