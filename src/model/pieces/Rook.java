package model.pieces;

import model.Board;
import model.Color;
import model.Position;

import java.util.List;

public class Rook extends Piece {
    public Rook(Color color, Position position) {
        super(color, position);
    }

    @Override
    public List<Position> getLegalMoves(Board board) {
        return board.getLinearMoves(this, false, true);
    }
}
