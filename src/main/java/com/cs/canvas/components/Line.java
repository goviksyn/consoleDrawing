package com.cs.canvas.components;

public class Line implements Shape {

    int row1;
    int col1;
    int row2;
    int col2;
    int rows;
    int cols;

    public Line(int col1, int row1, int col2, int row2,CanvasCoordinate[][] coordinates,int rows,int cols) {
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
    public void updateCanvas(CanvasCoordinate[][] coordinates) {
        if(row1 == row2)
            new HorizontalLine(row1,col1,row2,col2,coordinates);
        else if(col1 == col2)
            new VerticalLine(row1,col1,row2,col2,coordinates);
    }

    @Override
    public void isValid() throws IllegalArgumentException {
        if(!(row1 == row2 ^ col1 == col2))
            throw new IllegalArgumentException("Invalid coordinate for Line");
        if(!(validCoordinate(row1,rows) && validCoordinate(row2,rows) && validCoordinate(col1,cols) && validCoordinate(col2,cols))){
            throw  new IllegalArgumentException("Invalid coordinate for Line");
        }
    }
}
