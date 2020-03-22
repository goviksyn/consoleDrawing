package com.cs.canvas.components;

public class Rectangle implements Shape {
    int row1;
    int col1;
    int row2;
    int col2;
    int rows;
    int cols;

    public Rectangle(int col1, int row1, int col2, int row2,CanvasCoordinate[][] coordinates, int rows, int cols) {
        this.row1 = row1;
        this.col1 = col1;
        this.row2 = row2;
        this.col2 = col2;
        this.rows = rows;
        this.cols = cols;
        isValid();
        updateCanvas(coordinates);
    }

    @Override
    public void isValid() throws IllegalArgumentException {
        if(!(validCoordinate(row1,rows) && validCoordinate(row2,rows) && validCoordinate(col1,cols) && validCoordinate(col2,cols))){
            throw  new IllegalArgumentException("Invalid coordinate for Rectangle");
        }
    }

    @Override
    public void updateCanvas(CanvasCoordinate[][] coordinates) {
        new Line(col1,row1,col2,row1,coordinates,rows,cols);
        new Line(col1,row1,col1,row2,coordinates,rows,cols);
        new Line(col1,row2,col2,row2,coordinates,rows,cols);
        new Line(col2,row1,col2,row2,coordinates,rows,cols);
    }
}
