package com.cs.canvas.handler;

import com.cs.canvas.components.Canvas;
import com.cs.canvas.components.ConsolCanvas;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class BucketFillHandlerTest {

    BucketFillHandler bh;
    @Before
    public void setUp() throws Exception {
        bh = new BucketFillHandler();
    }

    @Test
    public void validRequest() {
        String request = "B 10 3 o";
        String [] req = bh.parser(request);
        bh.isValid(req);
    }

    @Test(expected = IllegalArgumentException.class)
    public void notValidRequest() {
        String request = "B 10 d o";
        String [] req = bh.parser(request);
        bh.isValid(req);
    }

    @Test(expected = IllegalArgumentException.class)
    public void notValidRequest1() {
        String request = "C 10 d o";
        String [] req = bh.parser(request);
        bh.isValid(req);
    }


    @Test
    public void handleRequest() {
      ConsolCanvas  c = new ConsolCanvas(4, 20);
      BucketFillHandler bucketFillHandler = new BucketFillHandler();
      Optional<Canvas> request = bucketFillHandler.handleRequest(c,"B 10 2 O");
      String expected =
              "----------------------\n" +
              "|OOOOOOOOOOOOOOOOOOOO|\n" +
              "|OOOOOOOOOOOOOOOOOOOO|\n" +
              "|OOOOOOOOOOOOOOOOOOOO|\n" +
              "|OOOOOOOOOOOOOOOOOOOO|\n" +
              "----------------------".trim();
        assertEquals("Comparing expected with actual", expected, request.get().toString().trim());

    }

    @Test(expected = IllegalArgumentException.class)
    public void handleRequestIllegal() {
        Canvas c =null;
        BucketFillHandler bucketFillHandler = new BucketFillHandler();
        Optional<Canvas> request = bucketFillHandler.handleRequest(c,"B 10 2 O");
    }
}