package com.company;

import java.sql.ResultSet;
import java.sql.Statement;

public class RB_Nomenclature {
    //protected int CodeNomenclature;
    //protected String Name;

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

    protected static void create(Statement statement, String Name) {
        final String sql = "INSERT INTO \"RB_Nomenclature\" (Name) VALUES (\"" + Name + "\");";
        try {
            statement.execute(sql);
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    protected static void read(Statement statement) {
        final String sql = "SELECT * FROM \"RB_Nomenclature\"";
        try {
            ResultSet result_set = statement.executeQuery(sql);
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

    protected static void update(Statement statement, int id, String Name) {
        final String sql = "UPDATE \"RB_Nomenclature\" SET Name = \""
                + Name + "\" WHERE CodeNomenclature = " + id + ";";
        try {
            statement.execute(sql);
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    protected static void delete_(Statement statement, int id) {
        final String sql = "DELETE FROM \"RB_Nomenclature\" WHERE CodeNomenclature = " + id + ";";
        try {
            statement.execute(sql);
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

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
