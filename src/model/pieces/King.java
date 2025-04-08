package model.pieces;

import model.Board;
import model.Color;
import model.Position;

import java.util.ArrayList;
import java.util.List;

public class King extends Piece {
    public King(Color color, Position position) {
        super(color, position);
    }
    @Override
    public List<Position> getLegalMoves(Board board) {
        List<Position> legalMoves = new ArrayList<>();
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
        for(int i = 0; i < dx.length; i++) {
            int x = i+dx[i];
            int y = i+dy[i];
            Position position = new Position(x, y);
            Piece p = board.getPiece(position);
            if(p != null && board.isInBounds(position) && p.getColor() != getColor()) {
                legalMoves.add(position);
            }
        }
        return legalMoves;
    }
}
