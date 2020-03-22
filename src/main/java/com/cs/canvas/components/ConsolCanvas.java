package com.cs.canvas.components;

public class ConsolCanvas implements Canvas {

    int rows;
    int cols;
    CanvasCoordinate[][] canvasCoordinates;

    public ConsolCanvas(int rows, int cols) {
        this.rows = rows + 2;
        this.cols = cols + 2;
        isValid();
        createCanvas();
    }

    @Override
    public void paint() {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(canvasCoordinates[row][col].display());
            }
        }
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                sb.append(canvasCoordinates[row][col].display());
            }
        }
       return sb.toString();
    }

    @Override
    public void createCanvas() {
            canvasCoordinates = new CanvasCoordinate[rows][cols];
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    if (row == 0 || row == rows - 1)
                        canvasCoordinates[row][col] = (col == cols - 1) ? new CanvasCoordinate("-", "no", "\n", row, col) : new CanvasCoordinate("-", "no", "", row, col);
                    else if (col == 0 || col == cols - 1)
                        canvasCoordinates[row][col] = (col == cols - 1) ? new CanvasCoordinate("|", "no", "\n", row, col) : new CanvasCoordinate("|", "no", "", row, col);
                    else
                        canvasCoordinates[row][col] = new CanvasCoordinate(" ", "no", "", row, col);
                }
            }
    }

    @Override
    public int getRow() {
        return this.rows;
    }

    @Override
    public int getCol() {
        return this.cols;
    }

    @Override
    public CanvasCoordinate[][] getCanvas() {
        return this.canvasCoordinates;
    }

    public void isValid() throws IllegalArgumentException {
        if(canvasCoordinates != null){
            throw new IllegalArgumentException("Canvas already initialized");
        }
        if (this.rows < 0 || this.cols < 0)
            throw new IllegalArgumentException("Not a valid Coordinate row :" + rows + " col " + cols + " Both should be positive");
    }


    public CanvasCoordinate[][] getCanvasCoordinates() {
        return canvasCoordinates;
    }

    public void setCanvasCoordinates(CanvasCoordinate[][] canvasCoordinates) {
        this.canvasCoordinates = canvasCoordinates;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }


}
