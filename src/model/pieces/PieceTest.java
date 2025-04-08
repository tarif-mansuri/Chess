package model.pieces;

import model.Board;
import model.Color;
import model.Position;

import java.util.List;

public class PieceTest {
    public static void main(String[] args) {
        Board board = new Board();

        // Place pieces for testing
        King whiteKing = new King(Color.WHITE, new Position(4, 4));
        Queen whiteQueen = new Queen(Color.WHITE, new Position(0, 3));
        Rook whiteRook = new Rook(Color.WHITE, new Position(0, 0));
        Bishop whiteBishop = new Bishop(Color.WHITE, new Position(2, 0));
        Knight whiteKnight = new Knight(Color.WHITE, new Position(4, 4));
        Pawn whitePawn = new Pawn(Color.WHITE, new Position(6, 4));

        // Set pieces on board
        board.setPiece(whiteKing);
        board.setPiece(whiteQueen);
        board.setPiece(whiteRook);
        board.setPiece(whiteBishop);
        board.setPiece(whiteKnight);
        board.setPiece(whitePawn);

        // Test and print legal moves
        testPieceMoves(board, whiteKing, "White King");
        testPieceMoves(board, whiteQueen, "White Queen");
        testPieceMoves(board, whiteRook, "White Rook");
        testPieceMoves(board, whiteBishop, "White Bishop");
        testPieceMoves(board, whiteKnight, "White Knight");
        testPieceMoves(board, whitePawn, "White Pawn");
    }

    public static void testPieceMoves(Board board, Piece piece, String name) {
        List<Position> moves = piece.getLegalMoves(board);
        System.out.println(name + " at " + piece.getPosition() + " legal moves:");
        for (Position pos : moves) {
            System.out.println("  -> " + pos);
        }
        System.out.println();
    }
}
