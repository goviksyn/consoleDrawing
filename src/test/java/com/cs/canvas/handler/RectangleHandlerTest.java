package com.cs.canvas.handler;

import com.cs.canvas.components.Canvas;
import com.cs.canvas.components.ConsolCanvas;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class RectangleHandlerTest {

    RectangleHandler rh;
    @Before
    public void setUp() throws Exception {
        rh = new RectangleHandler();
    }

    @Test
    public void validRequest() {
        String request = "R 14 1 18 3";
        String [] req = rh.parser(request);
        rh.isValid(req);
    }

    @Test(expected = IllegalArgumentException.class)
    public void notValidRequest() {
        String request = "R 6 3 6 4 4";
        String [] req = rh.parser(request);
        rh.isValid(req);
    }

    @Test(expected = IllegalArgumentException.class)
    public void notValidRequest1() {
        String request = "R 6 3 6 d";
        String [] req = rh.parser(request);
        rh.isValid(req);
    }


    @Test
    public void handleRequest() {
        ConsolCanvas c = new ConsolCanvas(4, 20);
        RectangleHandler rectangleHandler = new RectangleHandler();
        Optional<Canvas> request = rectangleHandler.handleRequest(c,"R 14 1 18 3");
        String expected =
                "----------------------\n" +
                "|             xxxxx  |\n" +
                "|             x   x  |\n" +
                "|             xxxxx  |\n" +
                "|                    |\n" +
                "----------------------".trim();
        assertEquals("Comparing expected with actual", expected, request.get().toString().trim());
    }

    @Test(expected = IllegalArgumentException.class)
    public void handleRequestIllegal() {
        Canvas c =null;
        RectangleHandler rectangleHandler = new RectangleHandler();
        Optional<Canvas> request = rectangleHandler.handleRequest(c,"R 1 2 6 2");
    }

    @Test(expected = IllegalArgumentException.class)
    public void handleRequestIllegal1() {
        ConsolCanvas c = new ConsolCanvas(4, 20);
        RectangleHandler rectangleHandler = new RectangleHandler();
        Optional<Canvas> request = rectangleHandler.handleRequest(c,"R 1 1 21 4");
    }

    @Test
    public void handleRequestEdge() {
        ConsolCanvas c = new ConsolCanvas(4, 20);
        RectangleHandler rectangleHandler = new RectangleHandler();
        Optional<Canvas> request = rectangleHandler.handleRequest(c,"R 1 1 20 4");
        String expected =
                                "----------------------\n" +
                                "|xxxxxxxxxxxxxxxxxxxx|\n" +
                                "|x                  x|\n" +
                                "|x                  x|\n" +
                                "|xxxxxxxxxxxxxxxxxxxx|\n" +
                                "----------------------".trim();
        assertEquals("Comparing expected with actual", expected, request.get().toString().trim());
    }
}