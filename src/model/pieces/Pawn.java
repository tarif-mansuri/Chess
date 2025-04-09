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
    public List<Position> getLegalMoves(Board board, Piece piece) {
        List<Position> legalMoves = new ArrayList<>();
        int dir = piece.getColor() == Color.WHITE ? 1 : -1;
        Position currentPosition = piece.getPosition();
        Position nextPosition = new Position(piece.getPosition().row + dir, piece.getPosition().col);
        Piece piece1 = board.getPiece(nextPosition);
        if(piece1==null && board.isInBoard(nextPosition)) {
            legalMoves.add(nextPosition);
        }else {
            int x1 = currentPosition.row + dir;
            int y1 = currentPosition.col-1;
            if(board.isInBoard(new Position(x1, y1))) {
                legalMoves.add(new Position(x1, y1));
            }

            y1 = currentPosition.col+1;
            if(board.isInBoard(new Position(x1, y1))) {
                legalMoves.add(new Position(x1, y1));
            }
        }
        return legalMoves;
    }
}
