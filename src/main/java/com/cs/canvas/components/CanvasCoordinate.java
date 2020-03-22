package com.cs.canvas.components;

import java.util.Objects;

public class CanvasCoordinate implements Validation {

    private String symbol;
    private String color;
    private String delim;
    private int row;
    private int col;

    public CanvasCoordinate(String symbol, String color, String delim, int row, int col) throws IllegalArgumentException {
        this.symbol = symbol;
        this.color = color;
        this.delim = delim;
        this.row = row;
        this.col = col;
        this.isValid();
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDelim() {
        return delim;
    }

    public void setDelim(String delim) {
        this.delim = delim;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CanvasCoordinate that = (CanvasCoordinate) o;
        return row == that.row &&
                col == that.col &&
                Objects.equals(symbol, that.symbol) &&
                Objects.equals(color, that.color) &&
                Objects.equals(delim, that.delim);
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbol, color, delim, row, col);
    }

    @Override
    public String toString() {
        return "CanvasCoordinate{" +
                "symbol='" + symbol + '\'' +
                ", color='" + color + '\'' +
                ", delim='" + delim + '\'' +
                ", row=" + row +
                ", col=" + col +
                '}';
    }


    public String display(){
        return symbol+delim;
    }


    @Override
    public void isValid() throws IllegalArgumentException {
        if(this.row < 0 || this.col < 0)
            throw new IllegalArgumentException("Not a valid Coordinate row :" +row+" col " +col + " Both should be positive");
    }
}
