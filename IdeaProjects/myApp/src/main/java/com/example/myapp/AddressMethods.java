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
        System.out.println("\tADDRESSES: ");
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM address");
            while (rs.next()) {
                System.out.println("\t\t" + rs.getInt(1) + " " + rs.getString(2));
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
            connection.commit();
            System.out.println("# ADDRESSES INSERTED SUCCESSFULLY.");
            prStmt.close();
        } catch (SQLException throwables) {
            try {
                System.out.println("Rolling INSERT ADDRESS back ...");
                connection.rollback();
                System.out.println("Rolled INSERT ADDRESS back successfully!");
            } catch (SQLException rollBackException) {
                rollBackException.printStackTrace();
            }
            throwables.printStackTrace();
        }
    }

}
