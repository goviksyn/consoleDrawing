package com.cs.canvas.handler;

import com.cs.canvas.components.Canvas;
import com.cs.canvas.components.ConsolCanvas;
import com.cs.canvas.utils.Utils;

import java.util.Optional;

public class CanvasHandler  implements  Handler{

    private String canvas = "C";
    Canvas consolCanvas;

    @Override
    public void isValid(String[] req) throws IllegalArgumentException {
        if (!(req.length == 3 && req[0].trim().equals(canvas) && Utils.isNumber(req[1]) && Utils.isNumber(req[2]))) {
            throw new IllegalArgumentException("Not a valid request");
        }
    }

    @Override
    public Optional<Canvas> handleRequest(Canvas cs, String request) {
       String[] req = parser(request);
        Optional<Canvas> result = Optional.empty();
        if (req[0].equals(canvas)) {
            isValid(req);
            if(consolCanvas == null){
                consolCanvas = new ConsolCanvas(Integer.parseInt(req[2]),Integer.parseInt(req[1]));
                result = Optional.of(consolCanvas);
            }else{
                System.out.println("Canvas already exist.");
            }
        }
       return result;
    }

    @Override
    public String getSymbol() {
        return this.canvas;
    }
}
