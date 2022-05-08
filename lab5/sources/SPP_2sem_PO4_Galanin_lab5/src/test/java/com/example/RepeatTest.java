package com.example;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RepeatTest {
    @Test
    public void repeat__e_0() {
        String actual = Repeat.repeat("e", 0);
        String expended = "";
        assertEquals(expended, actual);
    }

    @Test
    public void repeat__e_3() {
        String actual = Repeat.repeat("e", 3);
        String expended = "eee";
        assertEquals(expended, actual);
    }

    @Test
    public void repeat__ABC_2() {
        String actual = Repeat.repeat("ABC", 2);
        String expended = "ABCABC";
        assertEquals(expended, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void repeat__e_minus2() {
        String actual = Repeat.repeat("3", -2);
        String expended = "";
        assertEquals(expended, actual);
    }

    @Test(expected = NullPointerException.class)
    public void repeat__null_1() {
        String actual = Repeat.repeat(null, 1);
       // String expended = "";
       // assertEquals(expended, actual);
    }
}
