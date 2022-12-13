package com.example.myapp;

import java.sql.Connection;
import java.sql.SQLException;

public interface OperationUsers {
    public void getUsers();
    public void getUsersByID(int userid);
    public Integer insertUsers(String name);
    public void deleteUsers();
}
