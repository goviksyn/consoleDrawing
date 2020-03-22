package com.cs.canvas.handler;

import com.cs.canvas.components.Canvas;
import com.cs.canvas.components.ConsolCanvas;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class LineHandlerTest {

    LineHandler lh;
    @Before
    public void setUp() throws Exception {
        lh = new LineHandler();
    }

    @Test
    public void validRequest() {
        String request = "L 6 3 6 4";
        String [] req = lh.parser(request);
        lh.isValid(req);
    }

    @Test(expected = IllegalArgumentException.class)
    public void notValidRequest() {
        String request = "L 6 3 6 4 4";
        String [] req = lh.parser(request);
        lh.isValid(req);
    }

    @Test(expected = IllegalArgumentException.class)
    public void notValidRequest1() {
        String request = "L 6 3 6 d";
        String [] req = lh.parser(request);
        lh.isValid(req);
    }


    @Test
    public void handleRequest() {
        ConsolCanvas c = new ConsolCanvas(4, 20);
        LineHandler lineHandler = new LineHandler();
        Optional<Canvas> request = lineHandler.handleRequest(c,"L 1 2 6 2");
        String expected =
                "----------------------\n" +
                "|                    |\n" +
                "|xxxxxx              |\n" +
                "|                    |\n" +
                "|                    |\n" +
                "----------------------".trim();
        assertEquals("Comparing expected with actual", expected, request.get().toString().trim());
    }

    @Test(expected = IllegalArgumentException.class)
    public void handleRequestIllegal() {
        Canvas c =null;
        LineHandler lineHandler = new LineHandler();
        Optional<Canvas> request = lineHandler.handleRequest(c,"L 1 2 6 2");
    }
}