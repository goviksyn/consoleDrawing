package com.cs.canvas.handler;

import com.cs.canvas.components.BucketFill;
import com.cs.canvas.components.Canvas;
import com.cs.canvas.utils.Utils;

import java.util.Optional;

public class BucketFillHandler implements Handler {

    private String bucket = "B";

    @Override
    public void isValid(String[] req) throws IllegalArgumentException {
        if (!(req.length == 4 && req[0].trim().equals(bucket)
                && Utils.isNumber(req[1])
                && Utils.isNumber(req[2]))) {
            throw new IllegalArgumentException("Not a valid request");
        }
    }

    @Override
    public String getSymbol() {
        return this.bucket;
    }

    @Override
    public Optional<Canvas> handleRequest(Canvas cs, String request) {
        if(cs == null){
            throw new IllegalArgumentException("Missing canvas");
        }
        String[] req = parser(request);
        Optional<Canvas> result = Optional.empty();
        if (req[0].equals(bucket)) {
            isValid(req);
            new BucketFill(Integer.parseInt(req[1]),
                    Integer.parseInt(req[2]),
                    req[3],
                    cs.getCanvas(),
                    cs.getRow(),
                    cs.getCol());
            result = Optional.of(cs);
        }
        return result;
    }
}
