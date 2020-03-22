package com.cs.canvas.handler;

import com.cs.canvas.components.Canvas;
import com.cs.canvas.components.ConsolCanvas;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class CanvasHandlerTest {

    CanvasHandler ch;
    @Before
    public void setUp() throws Exception {
        ch = new CanvasHandler();
    }

    @Test
    public void validRequest() {
        String request = "C 10 3";
        String [] req = ch.parser(request);
        ch.isValid(req);
    }

    @Test(expected = IllegalArgumentException.class)
    public void notValidRequest() {
        String request = "B 10 d";
        String [] req = ch.parser(request);
        ch.isValid(req);
    }

    @Test(expected = IllegalArgumentException.class)
    public void notValidRequest1() {
        String request = "C 10 d";
        String [] req = ch.parser(request);
        ch.isValid(req);
    }


    @Test
    public void handleRequest() {
        ConsolCanvas c = new ConsolCanvas(4, 20);
        CanvasHandler canvasHandler = new CanvasHandler();
        Optional<Canvas> request = canvasHandler.handleRequest(c,"C 20 4");
        String expected = "----------------------\n" +
                "|                    |\n" +
                "|                    |\n" +
                "|                    |\n" +
                "|                    |\n" +
                "----------------------".trim();
        assertEquals("Comparing expected with actual", expected, request.get().toString().trim());
    }
}