package model.pieces;

import model.Board;
import model.Color;
import model.Position;

import java.util.List;

public abstract class Piece {
    private Color color;
    private Position position;

    public Piece(Color color, Position position) {
        this.color = color;
        this.position = position;
    }

    public Color getColor() {
        return color;
    }
    public Position getPosition() {
        return position;
    }

    public void moveTo(Position position){
        this.position = position;
    }

    public abstract List<Position> getLegalMoves(Board board, Piece piece);

}
