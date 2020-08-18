package com.HospitalDemo.HospitalDemo.Mysql;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TableCreate {

    private static final String SQL_CREATE = "CREATE TABLE PATIENTS"
            + "("
            + " ID serial,"
            + " NAME varchar(100) NOT NULL,"
            + " SALARY numeric(15, 2) NOT NULL,"
            + " CREATED_DATE timestamp with time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,"
            + " PRIMARY KEY (ID)"
            + ")";

    public static void main(String[] args) {

        try (Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://127.0.0.1:5432/postgres", "postgres", "mano");

             Statement statement = conn.createStatement()) {

            // if DDL failed, it will raise an SQLExceptiong
            statement.execute(SQL_CREATE);
            System.out.println("table created");

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
            System.out.println("error");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error");
        }

    }
    }



