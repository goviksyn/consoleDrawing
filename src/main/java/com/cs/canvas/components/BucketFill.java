package com.cs.canvas.components;

import java.util.HashSet;

public class BucketFill implements Shape {

    int row;
    int col;
    String color;
    int rows;
    int cols;
    CanvasCoordinate[][] coordinates;

    public BucketFill(int col, int row, String color, CanvasCoordinate[][] coordinates, int rows, int cols) {
        this.row = row;
        this.col = col;
        this.color = color;
        this.rows = rows;
        this.cols = cols;
        this.coordinates = coordinates;
        isValid();
        updateCanvas(coordinates);
    }


    @Override
    public void updateCanvas(CanvasCoordinate[][] coordinates) {
        bucketFill(row, col, color);
    }

    @Override
    public void isValid() throws IllegalArgumentException {
        if (!(validCoordinate(row, rows) && validCoordinate(col, cols))) {
            throw new IllegalArgumentException("Invalid coordinate");
        }
    }

    private HashSet<CanvasCoordinate> findNeighbour(int row, int col, CanvasCoordinate[][] coordinates) {
        HashSet<CanvasCoordinate> neighbour = new HashSet<>();
        if (validPoint(row, col + 1)) neighbour.add(coordinates[row][col + 1]);
        if (validPoint(row, col - 1)) neighbour.add(coordinates[row][col - 1]);
        if (validPoint(row + 1, col)) neighbour.add(coordinates[row + 1][col]);
        if (validPoint(row - 1, col)) neighbour.add(coordinates[row - 1][col]);

        return neighbour;
    }

    private boolean validPoint(int row, int col) {
        boolean flag = true;
        if (row < 0 || row > this.rows || col < 0 || col > this.cols)
            flag = false;
        return flag;
    }

    private void bucketFill(int row, int col, String color) {
        for (CanvasCoordinate cc : findNeighbour(row, col, coordinates)) {
            if (cc.getSymbol().equalsIgnoreCase(" ")) {
                cc.setSymbol(color);
                bucketFill(cc.getRow(), cc.getCol(), color);
            }
        }
    }
}
