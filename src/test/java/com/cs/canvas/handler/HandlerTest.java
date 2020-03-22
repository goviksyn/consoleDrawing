package com.cs.canvas.handler;

import com.cs.canvas.components.Canvas;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.Assert.*;

public class HandlerTest {
    Handler h;

    @Before
    public void setUp() throws Exception {
        h = new Handler() {
            @Override
            public String getSymbol() {
                return null;
            }

            @Override
            public Optional<Canvas> handleRequest(Canvas cs, String request) {
                return null;
            }

            @Override
            public void isValid(String[] request) throws IllegalArgumentException {

            }
        };
    }

    @Test
    public void parser() {
        String inComingReq = "C   20 4";
        String[] result = h.parser(inComingReq);
        String[] expresult = {"C","20","4"};
        Assert.assertArrayEquals( expresult, result );
    }
}