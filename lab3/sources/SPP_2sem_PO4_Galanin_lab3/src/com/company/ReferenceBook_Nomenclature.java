package com.company;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class ReferenceBook_Nomenclature {
    //protected int CodeNomenclature;
    //protected String Name;

    // Функция, которая создает таблицу
    protected static void create_table(Statement statement) {
        final String sql = """
            CREATE TABLE IF NOT EXISTS "RB_Nomenclature" (
                "CodeNomenclature" integer PRIMARY KEY AUTOINCREMENT UNIQUE,
                "Name" text
            );
        """;
        try {
            statement.execute(sql);
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    // Функция, которая добавляет элемент
    protected static void create(Statement statement, String Name) {
        final String sql = "INSERT INTO \"RB_Nomenclature\" (Name) VALUES (\"" + Name + "\");";
        try {
            statement.execute(sql);
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    // Функция, которая позволяет добавлять элемент через консоль
    protected static void create_interface(Statement statement) {
        Scanner in = new Scanner(System.in);
        System.out.println("\n = = = = = = = =");
        System.out.println("Create nomenclature element");
        System.out.print("Name: ");
        String Name = in.nextLine();
        create(statement, Name);
    }

    // Функция, которая выводит таблицу в консоль
    protected static void read(Statement statement) {
        final String sql = "SELECT * FROM \"RB_Nomenclature\"";
        try {
            ResultSet result_set = statement.executeQuery(sql);
            System.out.println("\n = = = = = = = =");
            System.out.println(" Table - RB_Nomenclature");
            System.out.printf("| %-8s | %-64s | \n", "#", "Name");
            System.out.printf("| %-8s | %-64s | \n",
                    "--------",
                    "----------------------------------------------------------------");
            while(result_set.next()) {
                int CodeNomenclature = result_set.getInt(1);
                String Name = result_set.getString(2);
                System.out.printf("| %8d | %-64s | \n", CodeNomenclature, Name);
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    // Функция, которая обновляет запись по id
    protected static void update(Statement statement, String id, String Name) {
        final String sql = "UPDATE \"RB_Nomenclature\" SET Name = \""
                + Name + "\" WHERE CodeNomenclature = " + id + ";";
        try {
            statement.execute(sql);
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    // Функция, которая обновляет запись через консоль
    protected static void update_interface(Statement statement) {
        Scanner in = new Scanner(System.in);
        System.out.println("\n = = = = = = = =");
        System.out.println("Update nomenclature element");

        System.out.print("id: ");
        String id = in.nextLine();

        System.out.print("Name: ");
        String Name = in.nextLine();

        update(statement, id, Name);
    }

    // Функция, которая удаляет запись по id
    protected static void delete_(Statement statement, String id) {
        final String sql = "DELETE FROM \"RB_Nomenclature\" WHERE CodeNomenclature = " + id + ";";
        try {
            statement.execute(sql);
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    // Функция, которая удаляет запись через консоль
    protected static void delete_interface(Statement statement) {
        Scanner in = new Scanner(System.in);
        System.out.println("\n = = = = = = = =");
        System.out.println("Delete nomenclature element");

        System.out.print("id: ");
        String id = in.nextLine();

        delete_(statement, id);
    }

    // Функция, которая удаляет таблицу
    protected static void drop_table(Statement statement) {
        final String sql = "DROP TABLE \"RB_Nomenclature\";";
        try {
            statement.execute(sql);
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
