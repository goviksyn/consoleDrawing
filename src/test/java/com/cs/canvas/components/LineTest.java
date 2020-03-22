package com.cs.canvas.components;

import org.junit.Test;

import static org.junit.Assert.*;

public class LineTest {

    @Test
    public void lineFillTest() {
        ConsolCanvas c = new ConsolCanvas(4, 20);
        Line line = new Line(1, 2, 6, 2, c.getCanvasCoordinates(), 4, 20);
        String expectedCoordinateString =
                        "----------------------\n" +
                        "|                    |\n" +
                        "|xxxxxx              |\n" +
                        "|                    |\n" +
                        "|                    |\n" +
                        "----------------------".trim();
        String actualCoordinateString = c.toString().trim();
        assertEquals("Comparing expected with actual", expectedCoordinateString, actualCoordinateString);
    }

    @Test
    public void line2FillTest() {
        ConsolCanvas c = new ConsolCanvas(4, 20);
        Line line2 = new Line(6, 3, 6, 4, c.getCanvasCoordinates(), 6, 22);
        String expectedCoordinateString =
                "----------------------\n" +
                "|                    |\n" +
                "|                    |\n" +
                "|     x              |\n" +
                "|     x              |\n" +
                "----------------------".trim();
        String actualCoordinateString = c.toString().trim();
        assertEquals("Comparing expected with actual", expectedCoordinateString, actualCoordinateString);
    }



}