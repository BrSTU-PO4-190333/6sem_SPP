package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Main {
    protected static Connection connection;

    public static void main(String[] args) {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:mydatabase.sqlite");
            System.out.println("Success connect to database");
            Statement statement = connection.createStatement();
            RB_Nomenclature.create_table(statement);
            RB_Nomenclature.create(statement, "red mouse");
            RB_Nomenclature.create(statement, "green mouse");
            RB_Nomenclature.read(statement);
            RB_Nomenclature.update(statement, 1, "grey mouse");
            RB_Nomenclature.delete_(statement, 2);
            RB_Nomenclature.read(statement);
            RB_Nomenclature.drop_table(statement);
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
