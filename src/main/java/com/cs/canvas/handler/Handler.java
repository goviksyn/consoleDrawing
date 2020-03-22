package com.cs.canvas.handler;

import com.cs.canvas.components.Canvas;

import java.util.Arrays;
import java.util.Optional;

public interface Handler extends Validation {

    String getSymbol();
    default String[] parser(String request) {
        return Arrays.stream(request.trim().split("\\s+")).map(String::trim).toArray(String[]::new);
    }


    Optional<Canvas> handleRequest(Canvas cs, String request);

}
