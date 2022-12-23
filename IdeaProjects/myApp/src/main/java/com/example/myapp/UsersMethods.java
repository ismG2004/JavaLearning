package com.example.myapp;

import java.sql.*;

public class UsersMethods implements OperationUsers {
    private final Connection connection;
    public static int index = 0;

    public UsersMethods(Connection connection) {
        this.connection = connection;
    }

    public void getUsers() {
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM users");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2));
            }
            stmt.close();
            rs.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void getUsersByID(int userid) {
        try {
            PreparedStatement prStmt = connection.prepareStatement(
                    "SELECT userid, name from users where userid=?"
            );

            prStmt.setInt(1, userid);

            prStmt.executeUpdate();
            System.out.println("# Got users by id");
            prStmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public Integer insertUsers(String name) {

        try {
            System.out.println("# INSERTING USERS...");
            PreparedStatement prStmt = connection.prepareStatement(
                    "INSERT INTO users VALUES (nextval('users_userid_seq'), ?)"
            );
            prStmt.setString(1, name);
            prStmt.executeUpdate();

            PreparedStatement prStmt2 = connection.prepareStatement(
                    "select last_value from users_userid_seq;"
            );
            ResultSet rs = prStmt2.executeQuery();
            while(rs.next())
                index = rs.getInt(1);

            System.out.println("# inserted users");
            rs.close();
            prStmt.close();
            prStmt2.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return index;
    }

    public void deleteUsers() {
        try {
            PreparedStatement prStmt = connection.prepareStatement(
                    "DELETE FROM users"
            );
            System.out.println("deleted all users");
            prStmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //methods...
}
