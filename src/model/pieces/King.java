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
    public List<Position> getLegalMoves(Board board, Piece piece) {
        int x = piece.getPosition().row;
        int y = piece.getPosition().col;
        List<Position> legalMoves = new ArrayList<>();
        int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
        int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};
        for(int i = 0; i < dx.length; i++) {
            int x1 = x + dx[i];
            int y1 = y + dy[i];
            Position position = new Position(x1, y1);
            Piece p1 = board.getPiece(position);
            //1.p1 ==null or different color
            if(board.isInBoard (position) && (p1==null || p1.getColor() != piece.getColor())) {
                legalMoves.add(position);
            }
        }
        return legalMoves;
    }
}
