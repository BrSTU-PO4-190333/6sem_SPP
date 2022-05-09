package com.example;

public class Repeat {
    public static String repeat(String pattern, int repeat) {
        if (pattern == null) {
            throw new NullPointerException();
        }

        if (repeat < 0) {
            throw new IllegalArgumentException();
        }

        String result = "";
        for (int i = 0; i < repeat; i++) {
            result += pattern;
        }
        return result;
    }
}
