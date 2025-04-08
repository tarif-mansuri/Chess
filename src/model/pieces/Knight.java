package model.pieces;

import model.Board;
import model.Color;
import model.Position;

import java.util.ArrayList;
import java.util.List;

public class Knight extends Piece {
    public Knight(Color color, Position position) {
        super(color, position);
    }

    @Override
    public List<Position> getLegalMoves(Board board) {
        List<Position> moves = new ArrayList<>();
        int[][] jumps = {
                {-2, -1}, {-2, 1}, {-1, -2}, {-1, 2},
                {1, -2},  {1, 2},  {2, -1},  {2, 1}
        };

        for (int[] jump : jumps) {
            int newRow = getPosition().row + jump[0];
            int newCol = getPosition().col + jump[1];
            Position newPos = new Position(newRow, newCol);

            if (board.isInBounds(newPos)) {
                Piece p = board.getPiece(newPos);
                if (p == null || p.getColor() != getColor()) {
                    moves.add(newPos);
                }
            }
        }

        return moves;
    }
}
