package com.cs.canvas.components;

import org.junit.Test;

import static org.junit.Assert.*;

public class RectangleTest {
    @Test
    public void rectangleFillTest() {
        ConsolCanvas c = new ConsolCanvas(4, 20);
        Rectangle rectangle = new Rectangle(14, 1, 18, 3, c.getCanvasCoordinates(), 6, 22);
        String expectedCoordinateString =
                "----------------------\n" +
                "|             xxxxx  |\n" +
                "|             x   x  |\n" +
                "|             xxxxx  |\n" +
                "|                    |\n" +
                "----------------------".trim();
        String actualCoordinateString = c.toString().trim();
        assertEquals("Comparing expected with actual", expectedCoordinateString, actualCoordinateString);
    }

}