package com.example.myapp;

import java.sql.*;

public interface ConnectionPool {
    Connection getConnection();
    boolean releaseConnection(Connection connection);
    String getUrl();
    String getUser();
    String getPassword();
    int getSize();
}