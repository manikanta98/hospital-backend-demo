package com.HospitalDemo.HospitalDemo.repositry;

import com.HospitalDemo.HospitalDemo.Entity.Patient;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PatientRepositry {

    private static final String SQL_INSERT = "INSERT INTO patients (first_name,last_name,dob,age,height,weight,facility) VALUES (?,?,?,?,?,?,?)";
    private static final String SQL_SELECT = "SELECT * FROM patients";
    private static List<Patient> patients=null;
    private PatientRepositry(){

    }

    public static List<Patient> getPatients(){
        patients = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/postgres", "postgres", "mano");
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT)) {
//            preparedStatement.setString(1, uname);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {


                String first_name = resultSet.getString("first_name");
                String last_name = resultSet.getString("last_name");
                Date dob = resultSet.getDate("dob");
                Integer age = resultSet.getInt("age");
                Integer height = resultSet.getInt("height");
                Integer weight = resultSet.getInt("weight");
                String facility = resultSet.getString("facility");
                Integer p_id = resultSet.getInt("p_id");


                Patient obj = new Patient();
                obj.setFirst_name(first_name);
                obj.setLast_name(last_name);
                obj.setDob(dob);
                obj.setAge(age);
                obj.setHeight(height);
                obj.setWeight(weight);
                obj.setFacility(facility);
                obj.setP_id(p_id);

                patients.add(obj);
                System.out.println(obj);
            }

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return patients;
    }

}


