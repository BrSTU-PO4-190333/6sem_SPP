package com.company;

public class Main {
    public static void main(String[] args) {
        System.out.println("Main thread created");
        MyThread class_instance = new MyThread();
        class_instance.start();

        try {
            class_instance.join();
        }
        catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("Main thread finished");
    }
}
