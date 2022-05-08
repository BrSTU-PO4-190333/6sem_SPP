package com.example;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RepeatTest {
    @Test
    public void repeat() {
        String actual;
        String expended;

        actual = Repeat.repeat("e", 0);
        expended = "";
        assertEquals(expended, actual);

        actual = Repeat.repeat("e", 3);
        expended = "eee";
        assertEquals(expended, actual);

        actual = Repeat.repeat("ABC", 2);
        expended = "ABCABC";
        assertEquals(expended, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void repeat__minus_repeat() {
        String actual = Repeat.repeat("3", -2);
        String expended = "";
        assertEquals(expended, actual);
    }

    @Test(expected = NullPointerException.class)
    public void repeat__null_pattern() {
        String actual = Repeat.repeat(null, 1);
       // String expended = "";
       // assertEquals(expended, actual);
    }
}
