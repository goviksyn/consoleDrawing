package com.cs.canvas.components;

import org.junit.Test;

import static org.junit.Assert.*;

public class BucketFillTest {
    @Test
    public void bucketFillTest() {
        ConsolCanvas c = new ConsolCanvas(4, 20);
        BucketFill bucketFill = new BucketFill(10, 3, "o", c.getCanvasCoordinates(), 6, 22);
        String expectedCoordinateString =
                "----------------------\n" +
                "|oooooooooooooooooooo|\n" +
                "|oooooooooooooooooooo|\n" +
                "|oooooooooooooooooooo|\n" +
                "|oooooooooooooooooooo|\n" +
                "----------------------".trim();
        String actualCoordinateString = c.toString().trim();
        assertEquals("Comparing expected with actual", expectedCoordinateString, actualCoordinateString);
    }

}