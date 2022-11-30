package com.example.myapp;

import java.sql.*;

public class MyConnection {
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "admin";
    private static final String DRIVER = "org.postgresql.Driver";
    private static Connection con ;

    public Connection createConnection() {
        try {
            Class.forName(DRIVER);
            try {
                con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        } catch (ClassNotFoundException exception) {
            exception.printStackTrace();
        }
        return con;
    }
}
