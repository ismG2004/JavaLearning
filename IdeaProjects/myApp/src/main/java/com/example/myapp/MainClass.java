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

        UsersMethods obj = new UsersMethods(connection);


        System.out.println("Before: ");
        objUsers.getUsers();
        objAddress.getAddress();

        /* 1st try */
//        index = objUsers.insertUsers("RAFIQ NEW");
//        objAddress.insertAddress(index, "FRANCE");
//        myCPobj.releaseConnection(connection);
//
//        index = objUsers.insertUsers("ALI");
//        objAddress.insertAddress(index, "SOMEWHERE");
//        myCPobj.releaseConnection(connection);


        /* 2nd try */
        System.out.println("----------------------------------");
        index = objUsers.insertUsers("MURAD+");
        objAddress.insertAddress(index, "PLACEMURAD");
        myCPobj.releaseConnection(connection);

        index = objUsers.insertUsers("NICAT++");
        objAddress.insertAddress(index, "PLACENICAT");
        myCPobj.releaseConnection(connection);

        index = objUsers.insertUsers("?+++");
        objAddress.insertAddress(index, "PLACE-VENDETTA");
        myCPobj.releaseConnection(connection);
        System.out.println("----------------------------------");

        /* 3rd try */
//        System.out.println("----------------------------------");
//        objUsers.generalInsertMethod("ISMAYIL", "1`");
//        System.out.println("Connection Pool Size: " + myCPobj.getSize());
//        myCPobj.releaseConnection(connection);
//        System.out.println("Connection Pool Size: " + myCPobj.getSize());
//
//        objUsers.generalInsertMethod("RAFIQ", "2");
//        System.out.println("Connection Pool Size: " + myCPobj.getSize());
//        myCPobj.releaseConnection(connection);
//        System.out.println("Connection Pool Size: " + myCPobj.getSize());
//
//        objUsers.generalInsertMethod("MURAD", "3");
//        System.out.println("Connection Pool Size: " + myCPobj.getSize());
//        myCPobj.releaseConnection(connection);
//        System.out.println("Connection Pool Size: " + myCPobj.getSize());
//        System.out.println("----------------------------------");


        System.out.println("After: ");
        objUsers.getUsers();
        objAddress.getAddress();

    }
}
