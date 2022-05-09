package com.example;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SumTest {
    @Test
    public void accum__int() {
        int actual; // Результат реальный
        int expected; // Результат ожидаемый

        actual = Sum.accum(1, 2,3,4,5,6,7,8,9);
        expected = 45;
        assertEquals(expected, actual); // Проверка на эквивалентность
    }

    @Test
    public void accum__long() {
        long actual; // Результат реальный
        long expected; // Результат ожидаемый

        actual = Sum.accum(1, 2,3,4,5,6,7,8,9);
        expected = 45;
        assertEquals(expected, actual); // Проверка на эквивалентность

        long [] arr = new long[] {Integer.MAX_VALUE, 2};
        actual = Sum.accum(arr);
        expected = Integer.MAX_VALUE + 2L;
        assertEquals(expected, actual); // Проверка на эквивалентность
    }
}
