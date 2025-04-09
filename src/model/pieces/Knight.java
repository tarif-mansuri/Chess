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
    public List<Position> getLegalMoves(Board board, Piece piece) {
        int[][] dr = {{-2,-1}, {-2,1}, {-1,2}, {1,2}, {2,1}, {2,-1}, {1,-2}, {-1,-2},};
        List<Position> legalMoves = new ArrayList<>();
        int x = piece.getPosition().row;
        int y = piece.getPosition().col;
        for(int[] d : dr) {
            int x1 = x+d[0];
            int y1 = y+d[1];
            Position position = new Position(x1, y1);
            Piece piece1 = board.getPiece(position);
            if(board.isInBoard(position) && (piece1==null || piece1.getColor() != piece.getColor())) {
                legalMoves.add(position);
            }
        }
        return legalMoves;
    }
}
