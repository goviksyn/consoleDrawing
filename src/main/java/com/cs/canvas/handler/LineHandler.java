package com.cs.canvas.handler;

import com.cs.canvas.components.Canvas;
import com.cs.canvas.components.Line;
import com.cs.canvas.utils.Utils;

import java.util.Optional;

public class LineHandler implements Handler {

    private String line = "L";

    @Override
    public void isValid(String[]  req) throws IllegalArgumentException {
        if (!(req.length == 5 && req[0].trim().equals(line)
                              && Utils.isNumber(req[1])
                              && Utils.isNumber(req[2])
                              && Utils.isNumber(req[3])
                              && Utils.isNumber(req[4]))) {
            throw new IllegalArgumentException("Not a valid request");
        }
    }
    @Override
    public Optional<Canvas> handleRequest(Canvas cs, String request) {
        if(cs == null){
            throw new IllegalArgumentException("Missing canvas");
        }
        String[] req = parser(request);
        Optional<Canvas> result = Optional.empty();
        if(req[0].equals(line)){
            isValid(req);
            new Line(Integer.parseInt(req[1]),
                    Integer.parseInt(req[2]),
                    Integer.parseInt(req[3]),
                    Integer.parseInt(req[4]),
                    cs.getCanvas(),
                    cs.getRow(),
                    cs.getCol());
            result = Optional.of(cs);
        }
        return result;
    }

    @Override
    public String getSymbol() {
        return this.line;
    }
}
