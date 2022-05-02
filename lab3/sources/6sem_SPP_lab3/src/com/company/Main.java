package com.company;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    protected static Connection connection;

    public static void main(String[] args) {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:mydatabase.sqlite");
            System.out.println("Success connect to database");
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
