package model;

import model.pieces.Piece;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private Piece[][] board = new Piece[8][8];

    public Piece[][] getBoard() {
        return board;
    }

    public void setBoard(Piece[][] board) {
        this.board = board;
    }

    public void setPiece(Piece piece) {
        board[piece.getPosition().row][piece.getPosition().col] = piece;
    }

    public Piece getPiece(Position position) {
        return board[position.row][position.col];
    }

    public void removePiece(Piece piece) {
        board[piece.getPosition().row][piece.getPosition().col] = null;
    }

    public void movePiece(Position from, Position to, Piece piece) {

    }

    public boolean isInBoard(Position position) {
        return position.row >= 0 && position.row < 8 && position.col >= 0 && position.col < 8;
    }

    public List<Position> getLegalMoves(Board board, Piece piece, boolean isDiagonal, boolean isStraight) {
        List<Position> legalMoves = new ArrayList<>();
        int x
    }
}
