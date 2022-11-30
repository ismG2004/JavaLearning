package com.example.myapp;

import java.sql.*;

public class AddressMethods implements OperationAddress {
    private final Connection connection;

    public AddressMethods(Connection connection) {
        this.connection = connection;
    }

//    public void getAddress() {
//        try {
//
//        } catch () {
//
//        }
//    }

    @Override
    public void getAddress() {
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM address");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2));
            }

            rs.close();
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void insertAddress(int userid, String street) {
        try {
            PreparedStatement prStmt = connection.prepareStatement(
                    "INSERT INTO address VALUES (?, ?)"
            );
            prStmt.setInt(1, userid);
            prStmt.setString(2, street);
            prStmt.executeUpdate();

            prStmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
