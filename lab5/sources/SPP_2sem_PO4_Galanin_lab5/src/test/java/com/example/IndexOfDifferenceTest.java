package com.example;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IndexOfDifferenceTest {
    @Test
    public void indexOfDifference() {
        int actual; // Результат реальный
        int expended; // Результат ожидаемый

        actual = IndexOfDifference.indexOfDifference("", "");
        expended = -1;
        assertEquals(expended, actual); // Проверка на эквивалентность

        actual = IndexOfDifference.indexOfDifference("", "abc");
        expended = 0;
        assertEquals(expended, actual); // Проверка на эквивалентность

        actual = IndexOfDifference.indexOfDifference("abc", "");
        expended = 0;
        assertEquals(expended, actual); // Проверка на эквивалентность

        actual = IndexOfDifference.indexOfDifference("abc", "abc");
        expended = -1;
        assertEquals(expended, actual); // Проверка на эквивалентность

        actual = IndexOfDifference.indexOfDifference("ab", "abxyz");
        expended = 2;
        assertEquals(expended, actual); // Проверка на эквивалентность

        actual = IndexOfDifference.indexOfDifference("abcde", "abxyz");
        expended = 2;
        assertEquals(expended, actual); // Проверка на эквивалентность

        actual = IndexOfDifference.indexOfDifference("abcde", "xyz");
        expended = 0;
        assertEquals(expended, actual); // Проверка на эквивалентность
    }
}
