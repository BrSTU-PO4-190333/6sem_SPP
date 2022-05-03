package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
    protected static Connection connection;
    protected static Statement statement;

    public static void main(String[] args) {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:mydatabase.sqlite");
            System.out.println("Success connect to database");
            statement = connection.createStatement();
        }
        catch (Exception e) {
            System.out.println(e);
            return;
        }
        init_database();
        main_menu();
    }

    // Функция, которая создает таблицы в базе данных
    protected static void init_database() {
        RB_Nomenclature.create_table(statement);
    }

    // Функция, которая вызывает главное меню
    protected static void main_menu() {
        String key;
        Scanner in = new Scanner(System.in);
        while(true) {
            print_main_menu();
            key = in.nextLine();

            if (key.equals("0")) {
                break;
            }

            if (key.equals("1")) {
                RB_Nomenclature.create_interface(statement);
                press_any_key();
                continue;
            }

            if (key.equals("2")) {
                RB_Nomenclature.read(statement);
                press_any_key();
                continue;
            }

            if (key.equals("3")) {
                RB_Nomenclature.update_interface(statement);
                press_any_key();
                continue;
            }

            if (key.equals("4")) {
                RB_Nomenclature.delete_interface(statement);
                press_any_key();
                continue;
            }

            if (key.equals("7")) {
                RB_Nomenclature.create_table(statement);
                press_any_key();
                continue;
            }

            if (key.equals("8")) {
                RB_Nomenclature.drop_table(statement);
                press_any_key();
                continue;
            }
        }
    }

    // Функция, которая печатает меню
    protected static void print_main_menu() {
        System.out.println("Menu:");
        System.out.println("1. Create element");
        System.out.println("2. Read table");
        System.out.println("3. Update element");
        System.out.println("4. Delete element");
        System.out.println("7. !!! Create database!!!");
        System.out.println("8. !!! Drop database!!!");
        System.out.println("0. Exit");
        System.out.println("");
    }

    // Функция, которая ожидает ввода пользователя
    protected static void press_any_key() {
        System.out.print("Press any key... ");
        Scanner in = new Scanner(System.in);
        in.nextLine();
    }
}
