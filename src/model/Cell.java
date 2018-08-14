package model;

import java.util.ArrayList;
import java.util.List;

public class Cell {

    private int cellNumber;
    private int row;
    private int column;

    public Cell(int cellNumber, int row, int column) {
        this.cellNumber = cellNumber;
        this.row = row;
        this.column = column;
    }

    public int getCellNumber() {
        return cellNumber;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }
}
