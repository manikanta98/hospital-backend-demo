package com.HospitalDemo.HospitalDemo.Dao;

import com.HospitalDemo.HospitalDemo.Entity.Patient;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PatientDao {

    private static final String SQL_INSERT = "INSERT INTO patients (first_name,last_name,dob,age,height,weight,facility) VALUES (?,?,?,?,?,?,?)";
    private static final String SQL_SELECT = "SELECT * FROM patients";
    private static final String SQL_UPDATE = "UPDATE public.patients\n" +
            "\tSET first_name=?, last_name=?, dob=?, age=?, height=?, weight=?, facility=?\n" +
            "\tWHERE p_id=?;";
    private static final String SQL_DELETE = "DELETE FROM PATIENTS WHERE p_id =?";
    private static final String SQL_SELECTBY_ID ="SELECT * FROM PATIENTS WHERE p_id=?";
    private static List<Patient> patients=null;
    private static List<Patient> patient=null;

    private PatientDao(){


    }

    public static List<Patient> getPatients(){
        patients = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/postgres", "postgres", "mano");
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT)) {

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

    public static void addPatient(Patient patient){
        {

            try (Connection conn = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/postgres", "postgres", "mano");
                 PreparedStatement preparedStatement = conn.prepareStatement(SQL_INSERT)) {

                preparedStatement.setString(1, patient.getFirst_name());
                preparedStatement.setString(2, patient.getLast_name());
                preparedStatement.setDate(3, patient.getDob());
                preparedStatement.setInt(4, patient.getAge());
                preparedStatement.setInt(5,patient.getHeight());
                preparedStatement.setInt(6,patient.getWeight());
                preparedStatement.setString(7, patient.getFacility());
                int row = preparedStatement.executeUpdate();

                // rows affected
                //System.out.println(row); // 1t

            } catch (SQLException e) {
                System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

    public static void updatePatient(Integer id, Patient patient){
        {

            try (Connection conn = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/postgres", "postgres", "mano");
                 PreparedStatement preparedStatement = conn.prepareStatement(SQL_UPDATE)) {

                preparedStatement.setString(1, patient.getFirst_name());
                preparedStatement.setString(2, patient.getLast_name());
                preparedStatement.setDate(3, patient.getDob());
                preparedStatement.setInt(4, patient.getAge());
                preparedStatement.setInt(5,patient.getHeight());
                preparedStatement.setInt(6,patient.getWeight());
                preparedStatement.setString(7, patient.getFacility());
                preparedStatement.setInt(8,id);
                int row = preparedStatement.executeUpdate();

                // rows affected
                //System.out.println(row); // 1t

            } catch (SQLException e) {
                System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

    public static List<Patient> deletePatient(Integer id){
        try (Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/postgres", "postgres", "mano");
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_DELETE)) {

            preparedStatement.setInt(1, id);

            int row = preparedStatement.executeUpdate();

            // rows affected
            System.out.println(row);

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return patients;
    }

    public static List<Patient> getPatientById(Integer id){
        patient = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/postgres", "postgres", "mano");
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECTBY_ID)) {

            preparedStatement.setInt(1, id);
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

                patient.add(obj);
                System.out.println(obj);
            }

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return patient;
    }

}


