package com.cs.canvas.components;

public interface Shape  extends Validation{
    String filler ="x";
    void updateCanvas(CanvasCoordinate[][] coordinates);
    default boolean validCoordinate(int point,int range){
        boolean valid = true;
        if(point < 0 || point > range - 2)
            valid = false;
        return valid;
    }
}
