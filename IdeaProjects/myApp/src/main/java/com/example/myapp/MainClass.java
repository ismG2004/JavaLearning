package com.example.myapp;

import java.sql.*;

public class MainClass {

    public static void main(String[] args) throws SQLException {

//        int index = 0;

//        Connection connection = new MyConnection().createConnection();
//        OperationUsers objUsers = new UsersMethods(connection);
//        OperationAddress objAddress = new AddressMethods(connection);
//
//        UsersMethods obj = new UsersMethods(connection);
//
//        System.out.println("# Before: ");
//        objUsers.getUsers();
//        objAddress.getAddress();
//
//        index = objUsers.insertUsers("Rafiq");
//        objAddress.insertAddress(index, "Yasamal");
//
//        System.out.println("# After: ");
//        objUsers.getUsers();
//        objAddress.getAddress();


        int index = 0;

        MyConnectionPool myCPobj = new MyConnectionPool();
        myCPobj.createConnection();
        myCPobj.create();

        Connection connection = myCPobj.getConnection();
        OperationUsers objUsers = new UsersMethods(connection);
        OperationAddress objAddress = new AddressMethods(connection);
        myCPobj.releaseConnection(connection);



        objUsers.getUsers();

    }
}
