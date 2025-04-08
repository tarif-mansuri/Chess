package model.pieces;

import model.Board;
import model.Color;
import model.Position;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece {
    public Pawn(Color color, Position position) {
        super(color, position);
    }

    @Override
    public List<Position> getLegalMoves(Board board) {
        List<Position> moves = new ArrayList<>();
        int direction = (getColor() == Color.WHITE) ? -1 : 1;

        Position forward = new Position(getPosition().row + direction, getPosition().col);
        if (board.isInBounds(forward) && board.getPiece(forward) == null) {
            moves.add(forward);

            // First move: 2 steps
            int startRow = (getColor() == Color.WHITE) ? 6 : 1;
            if (getPosition().row == startRow) {
                Position twoForward = new Position(getPosition().row + 2 * direction, getPosition().col);
                if (board.getPiece(twoForward) == null) {
                    moves.add(twoForward);
                }
            }
        }

        // Capture diagonally
        int[] dx = {-1, 1};
        for (int d : dx) {
            Position diag = new Position(getPosition().row + direction, getPosition().col + d);
            if (board.isInBounds(diag)) {
                Piece enemy = board.getPiece(diag);
                if (enemy != null && enemy.getColor() != getColor()) {
                    moves.add(diag);
                }
            }
        }

        // En passant is handled in Game logic
        return moves;

    }
}
