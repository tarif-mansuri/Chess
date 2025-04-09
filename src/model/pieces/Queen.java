package model.pieces;

import model.Board;
import model.Color;
import model.Position;

import java.util.List;

public class Queen extends Piece {

    public Queen(Color color, Position position) {
        super(color, position);
    }

    @Override
    public List<Position> getLegalMoves(Board board, Piece piece) {
        return List.of();
    }
}
