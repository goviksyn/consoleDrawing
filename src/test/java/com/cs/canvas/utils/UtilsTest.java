package com.cs.canvas.utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class UtilsTest {

    @Test
    public void isNumberFalse() {
        String s ="k";
        boolean isNumber = Utils.isNumber(s);
        assertEquals(false,isNumber);
    }

    @Test
    public void isNumberTrueWithSpace() {
        String s ="3 ";
        boolean isNumber = Utils.isNumber(s);
        assertEquals(true,isNumber);
    }

    @Test
    public void isNumberTrue() {
        String s ="3";
        boolean isNumber = Utils.isNumber(s);
        assertEquals(true,isNumber);
    }
}