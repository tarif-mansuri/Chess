package model.pieces;

import model.Board;
import model.Position;

import java.util.List;

public class Queen extends Piece {
    @Override
    public List<Position> getLegalMoves(Board board) {
        return List.of();
    }
}
