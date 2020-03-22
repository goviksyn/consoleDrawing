package com.cs.canvas.components;

class VerticalLine implements Shape {

    int row1;
    int col1;
    int row2;
    int col2;

    public VerticalLine(int row1, int col1, int row2, int col2, CanvasCoordinate[][] coordinates) {
        this.row1 = row1;
        this.col1 = col1;
        this.row2 = row2;
        this.col2 = col2;
        isValid();
        updateCanvas(coordinates);
    }

    @Override
    public void isValid() throws IllegalArgumentException {
        if (col1 != col2)
            throw new IllegalArgumentException("Not a valid coordinate for row");
    }

    @Override
    public void updateCanvas(CanvasCoordinate[][] coordinates) {
        for (int i = row1; i <= row2; i++) {
            CanvasCoordinate canvasCoordinate = coordinates[i][col1];
            canvasCoordinate.setSymbol(filler);
            coordinates[i][col1] = canvasCoordinate;
        }
    }
}
