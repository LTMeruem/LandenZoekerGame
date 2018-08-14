package model;

public class Grid {

    private int rows;
    private int columns;
    private Cell[][] cells;

    public Grid(int rows, int columns){
        this.rows = rows;
        this.columns = columns;
        cells = new Cell[rows][columns];
        generateGrid();
    }

    public void generateGrid(){
        int number = rows + columns;

        for (int i = 0; i < this.rows; i+= 2) {
            for (int j = 0; j < this.columns; j++) {
                cells[i][j] = new Cell(number, i, j);
                number--;
            }
            for (int j = this.columns - 1; j >= 0; j--) {
                cells[i + 1][j] = new Cell(number, i, j);
                number--;
            }
        }
    }


    public Cell[][] getCells() {
        return cells;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }
}

