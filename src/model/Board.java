package model;

import model.pieces.Piece;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private Piece[][] board = new Piece[8][8];

    public Piece getPiece(Position position) {
        if(!isInBounds(position)) {
            return null;
        }
        return board[position.row][position.col];
    }
    public void setPiece(Piece piece) {
        board[piece.getPosition().row][piece.getPosition().col] = piece;
    }

    public void movePiece(Position from, Position to) {
        Piece piece = getPiece(from);
        if(piece == null) {
            return;
        }
        removePiece(piece);
        Piece targetPiece = getPiece(to);
        if(targetPiece != null) {
            //Handle capture cases
        }
        piece.setPosition(to);
        setPiece(piece);
    }

    public void removePiece(Piece piece) {
        board[piece.getPosition().row][piece.getPosition().col] = null;
    }

   public boolean isInBounds(Position position) {
        return position.row >= 0 && position.row < 8 && position.col >= 0 && position.col < 8;
   }

   public List<Position> getLinearMoves(Piece piece, boolean isDiagonal, boolean isStraight) {
        List<Position> moves = new ArrayList<>();
        int[][] dr = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, //Vertical and Horizontal
                      {-1, -1}, {-1, 1}, {1, 1}, {1, -1} //Diagonal
        };
        for(int[] d : dr) {
            int x = piece.getPosition().row + d[0];
            int y = piece.getPosition().col + d[1];
            boolean isDiagonalPosition = Math.abs(d[0]) == Math.abs(d[1]);
            if(isDiagonal && isDiagonalPosition) {
                while(isInBounds(new Position(x,y))){
                    Piece targetdPiece = getPiece(new Position(x,y));
                    if(targetdPiece == null){
                        moves.add(new Position(x,y));

                    }else if(piece.getColor() != targetdPiece.getColor()){
                        moves.add(new Position(x,y)); // Capture
                        break;
                    }else{
                        break;
                    }
                    x = x + d[0];
                    y = y + d[1];
                }
            }

            x = piece.getPosition().row + d[0];
            y = piece.getPosition().col + d[1];

            if(isStraight && !isDiagonalPosition) {
                while(isInBounds(new Position(x,y))){
                    Piece targetdPiece = getPiece(new Position(x,y));
                    if(targetdPiece == null){
                        moves.add(new Position(x,y));

                    }else if(piece.getColor() != targetdPiece.getColor()){
                        moves.add(new Position(x,y)); // Capture
                        break;
                    }else{
                        break;
                    }
                    x = x + d[0];
                    y = y + d[1];
                }
            }


        }
        return moves;
   }

    public void printBoard() {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Piece piece = board[row][col];
                if (piece == null) {
                    System.out.print(" . ");
                } else {
                    System.out.print(" " + piece.toString().charAt(0) + " ");
                }
            }
            System.out.println("  <- Row " + row);
        }
    }
}
