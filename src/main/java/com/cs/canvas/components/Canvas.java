package com.cs.canvas.components;

public interface Canvas extends Validation {
     void paint();
     void createCanvas();
     int getRow();
     int getCol();
     CanvasCoordinate[][] getCanvas();
}
