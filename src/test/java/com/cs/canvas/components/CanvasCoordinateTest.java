package com.cs.canvas.components;

import org.junit.Test;

public class CanvasCoordinateTest {

    @Test
    public void display() {
    }

    @Test(expected = IllegalArgumentException.class)
    public void createWithIllegalArg() throws IllegalArgumentException {
        new CanvasCoordinate("","","", 2, -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createWithIllegalArg2() throws IllegalArgumentException {
        new CanvasCoordinate("","","", -2, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createWithIllegalArg3() throws IllegalArgumentException {
        new CanvasCoordinate("","","", -2, -1);
    }

    @Test
    public void create() throws Exception {
        new CanvasCoordinate("","","", 2, 1);
    }
}