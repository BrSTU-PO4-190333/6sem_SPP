package com.example.spp_2sem_po4_galanin_lab4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Database {
    public static Connection get_connect_to_database() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:mydatabase.sqlite");
            System.out.println("Success connect to database");
            return connection;
        }
        catch (Exception exception) {
            System.out.println(exception);
            return null;
        }
    }

    public static void execute_sql_query(String sql) {
        System.out.println(sql);
        Connection connection = Database.get_connect_to_database();
        Statement statement;
        try{
            statement = connection.createStatement();
            statement.executeUpdate(sql);
        }catch(Exception exception){
            exception.printStackTrace();
        }
    }

    public static void init() {
        String sql = ModelProducer.get_CREATE_TABLE_sql();
        Database.execute_sql_query(sql);
    }
}
