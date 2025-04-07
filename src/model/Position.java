package model;

public class Position {
    int row;
    int col;
    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }
    public boolean equals(Position p) {
        return row == p.row && col == p.col;
    }

    public String toString() {
        return "(" + row + ", " + col + ")";
    }
}
