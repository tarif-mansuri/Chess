package model.pieces;

import model.Board;
import model.Color;
import model.Position;

import java.util.ArrayList;
import java.util.List;

public class Bishop extends Piece {
    public Bishop(Color color, Position position) {
        super(color, position);
    }

    @Override
    public List<Position> getLegalMoves(Board board) {
        List<Position> legalMoves = new ArrayList<>();
        return board.getLinearMoves(this, true, false);
    }
}
