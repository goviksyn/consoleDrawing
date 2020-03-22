package com.cs.canvas.handler;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TerminationHandlerTest {

    TerminationHandler th;

    @Before
    public void setUp() throws Exception {
        th  = new TerminationHandler();
    }

    @Test
    public void validRequest() {
        String request = "Q";
        String[] req = th.parser(request);
        th.isValid(req);
    }

    @Test(expected = IllegalArgumentException.class)
    public void notValidRequest() {
        String request = "Q d";
        String[] req = th.parser(request);
        th.isValid(req);
    }
}