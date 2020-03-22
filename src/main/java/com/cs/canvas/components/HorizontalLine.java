package com.cs.canvas.components;

class HorizontalLine implements Shape {

    int row1;
    int col1;
    int row2;
    int col2;

    public HorizontalLine(int row1, int col1, int row2, int col2, CanvasCoordinate[][] coordinates) {
        this.row1 = row1;
        this.col1 = col1;
        this.row2 = row2;
        this.col2 = col2;
        isValid();
        updateCanvas(coordinates);
    }

    @Override
    public void isValid() throws IllegalArgumentException {
        if (row1 != row2)
            throw new IllegalArgumentException("Not a valid coordinate for row");

    }

    @Override
    public void updateCanvas(CanvasCoordinate[][] coordinates) {
        for (int i = col1; i <= col2; i++) {
            CanvasCoordinate canvasCoordinate = coordinates[row1][i];
            canvasCoordinate.setSymbol(filler);
            coordinates[row1][i] = canvasCoordinate;
        }
    }
}
