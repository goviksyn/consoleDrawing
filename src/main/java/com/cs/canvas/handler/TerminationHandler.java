package com.cs.canvas.handler;

import com.cs.canvas.components.Canvas;

import java.util.Optional;

public class TerminationHandler implements Handler {

    private String quit = "Q";

    @Override
    public Optional<Canvas> handleRequest(Canvas cs, String request) {
        String[] req = parser(request);
        if(req[0].equals(quit)){
            isValid(req);
            System.exit(0);
        }
        return Optional.empty();
    }

    @Override
    public void isValid(String[] req) throws IllegalArgumentException {
        if (!(req.length == 1 && req[0].trim().equals(quit))) {
            throw new IllegalArgumentException("Not a valid request");
        }
    }

    @Override
    public String getSymbol() {
        return this.quit;
    }
}
