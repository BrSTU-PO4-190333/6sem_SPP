package com.example;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SumTest {
    @Test
    public void accum() {
        // Результат реальный
        int actual = Sum.accum(1, 2,3,4,5,6,7,8,9);
        // Результат ожидаемый
        int expected = 45;
        // Проверка на эквивалентность
        assertEquals(expected, actual);
    }
}
