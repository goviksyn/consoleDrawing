package com.cs.canvas.handler;

import com.cs.canvas.components.Canvas;

import java.util.Optional;

public class InvalidRequestHandler implements Handler {
    @Override
    public Optional<Canvas> handleRequest(Canvas cs, String request) {
        System.out.println("Invalid request");
        return Optional.empty();
    }

    @Override
    public void isValid(String[] request) throws IllegalArgumentException {

    }

    @Override
    public String getSymbol() {
        return "invalid";
    }
}
