package com.example.myapp;

import java.sql.*;

public class UsersMethods implements OperationUsers {
    private final Connection connection;
    public static int index = 0;

    public UsersMethods(Connection connection) {
        this.connection = connection;
    }

    public void getUsers() {
        System.out.println("\tUSERS: ");
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM users");
            while (rs.next()) {
                System.out.println("\t\t" + rs.getInt(1) + " " + rs.getString(2));
            }
            rs.close();
            stmt.close();
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

    public void generalInsertMethod(String name, String street) {
        try {
            System.out.println("# INSERTING USERS...");
            PreparedStatement prStmt1 = connection.prepareStatement(
                    "INSERT INTO users VALUES (nextval('users_userid_seq'), ?)"
            );
            prStmt1.setString(1, name);
            prStmt1.executeUpdate();
            System.out.println("# USERS INSERTED SUCCESSFULLY.");


            System.out.println("# INSERTING ADDRESS...");
            PreparedStatement prStmt2 = connection.prepareStatement(
                    "INSERT INTO address values (currval('users_userid_seq'), ?)"
            );
            prStmt2.setString(1, street);
            prStmt2.executeUpdate();
            System.out.println("# ADDRESS INSERTED SUCCESSFULLY.");

            connection.commit();
            prStmt1.close();
            prStmt2.close();
//            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            try {
                System.out.println("Rolling 'INSERT USERS' & 'INSERT ADDRESS' back ...");
                connection.rollback(); // ROLLBACK
                System.out.println("Rolled 'INSERT USERS' & 'INSERT ADDRESS' back successfully!");
            } catch (SQLException rollBackException) {
                rollBackException.printStackTrace();
            }

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
            connection.commit();   // COMMIT
            PreparedStatement prStmt2 = connection.prepareStatement(
                    "select last_value from users_userid_seq;"
            );
            ResultSet rs = prStmt2.executeQuery();

            while(rs.next())
                index = rs.getInt(1);

            System.out.println("# USERS INSERTED SUCCESSFULLY.");

            rs.close();
            prStmt.close();
            prStmt2.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            try {
                System.out.println("Rolling INSERT USERS back ...");
                connection.rollback(); // ROLLBACK
                System.out.println("Rolled INSERT USERS back successfully!");
            } catch (SQLException rollBackException) {
                rollBackException.printStackTrace();
            }

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
