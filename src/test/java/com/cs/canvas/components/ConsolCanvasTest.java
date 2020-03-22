package com.cs.canvas.components;

import org.junit.Test;

import static org.junit.Assert.*;

public class ConsolCanvasTest {

    @Test
    public void canvasFillTest() {
        ConsolCanvas c = new ConsolCanvas(4, 20);
        String expectedCoordinateString =
                        "----------------------\n" +
                        "|                    |\n" +
                        "|                    |\n" +
                        "|                    |\n" +
                        "|                    |\n" +
                        "----------------------".trim();
        String actualCoordinateString = c.toString().trim();
        assertEquals("Comparing expected with actual", expectedCoordinateString, actualCoordinateString);
    }

}