package com.example;

public class IndexOfDifference {
    public static int indexOfDifference(String str1, String str2) {
        if (str1.equals(str2)) {
            return -1;
        }

        int length1 = str1.length();
        int length2 = str2.length();
        int min = length1 < length2 ? length1 : length2;
        for (int i = 0; i < min; ++i) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return i;
            }
        }
        return min;
    }
}
