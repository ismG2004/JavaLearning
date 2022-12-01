package com.example.myapp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MyConnectionPool implements ConnectionPool {
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "admin";
    private static final String DRIVER = "org.postgresql.Driver";
    private List<Connection> connectionPool = new ArrayList<>(DEFAULT_POOL_SIZE);
    private List<Connection> usedConnections = new ArrayList<>();
    private static final int DEFAULT_POOL_SIZE = 10;


    public void create() {
        try {
//            List<Connection> connectionPool = new ArrayList<>(DEFAULT_POOL_SIZE);
            for (int i = 0; i < DEFAULT_POOL_SIZE; i++)
                connectionPool.add(createConnection());

        } catch (SQLException createMethodException) {
            createMethodException.printStackTrace();
        }
    }

    public Connection createConnection() throws SQLException {
        Connection con = null;
        try {
            Class.forName(DRIVER);
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            con.setAutoCommit(false);
        } catch (ClassNotFoundException exception) {
            exception.printStackTrace();
        }
        return con;
    }

    @Override
    public Connection getConnection() {
        Connection connection = connectionPool.remove(connectionPool.size() - 1);
        usedConnections.add(connection);
        return connection;
    }

    @Override
    public boolean releaseConnection(Connection connection) {
        System.out.println("# RELEASING CONNECTION...");
        connectionPool.add(connection);
        System.out.println("# CONNECTION RELEASED.");
        return usedConnections.remove(connection);
    }

    @Override
    public int getSize() {
        return connectionPool.size();
    }

    @Override
    public String getUrl() {
        return URL;
    }

    @Override
    public String getUser() {
        return USERNAME;
    }

    @Override
    public String getPassword() {
        return PASSWORD;
    }

}
