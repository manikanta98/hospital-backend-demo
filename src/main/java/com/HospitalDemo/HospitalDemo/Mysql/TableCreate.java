package com.HospitalDemo.HospitalDemo.Mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TableCreate {

    private static final String SQL_CREATE = "CREATE TABLE EMPLOYEE"
            + "("
            + " ID INT NOT NULL AUTO_INCREMENT,"
            + " FIRST_NAME VARCHAR(100) NOT NULL,"
            + " LAST_NAME VARCHAR(100) NOT NULL,"
            + " AGE INT,"
            + " HEIGHT INT,"
            + " WEIGHT INT,"
            + " FACILITY VARCHAR(100) NOT NULL,"
            + " PRIMARY KEY (ID)"
            + ")";
    public static void main(String[] args) {

        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/demo", "root", "root");
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_CREATE)) {

            preparedStatement.execute();

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }




}
