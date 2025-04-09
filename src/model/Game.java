package model;

import model.pieces.*;

import java.util.List;
import java.util.Scanner;

public class Game {
    private Board board;
    private Player whitePlayer;
    private Player blackPlayer;
    private Player currentPlayer;
    private boolean gameOver;

    public Game() {
        board = new Board();
        whitePlayer = new Player(Color.WHITE);
        blackPlayer = new Player(Color.BLACK);
        currentPlayer = whitePlayer;
        gameOver = false;

        initializePieces();
    }

    private void initializePieces() {
        // Pawns
        for (int i = 0; i < 8; i++) {
            setupPiece(new Pawn(Color.WHITE, new Position(6, i)), whitePlayer);
            setupPiece(new Pawn(Color.BLACK, new Position(1, i)), blackPlayer);
        }

        // Rooks
        setupPiece(new Rook(Color.WHITE, new Position(7, 0)), whitePlayer);
        setupPiece(new Rook(Color.WHITE, new Position(7, 7)), whitePlayer);
        setupPiece(new Rook(Color.BLACK, new Position(0, 0)), blackPlayer);
        setupPiece(new Rook(Color.BLACK, new Position(0, 7)), blackPlayer);

        // Knights
        setupPiece(new Knight(Color.WHITE, new Position(7, 1)), whitePlayer);
        setupPiece(new Knight(Color.WHITE, new Position(7, 6)), whitePlayer);
        setupPiece(new Knight(Color.BLACK, new Position(0, 1)), blackPlayer);
        setupPiece(new Knight(Color.BLACK, new Position(0, 6)), blackPlayer);

        // Bishops
        setupPiece(new Bishop(Color.WHITE, new Position(7, 2)), whitePlayer);
        setupPiece(new Bishop(Color.WHITE, new Position(7, 5)), whitePlayer);
        setupPiece(new Bishop(Color.BLACK, new Position(0, 2)), blackPlayer);
        setupPiece(new Bishop(Color.BLACK, new Position(0, 5)), blackPlayer);

        // Queens
        setupPiece(new Queen(Color.WHITE, new Position(7, 3)), whitePlayer);
        setupPiece(new Queen(Color.BLACK, new Position(0, 3)), blackPlayer);

        // Kings
        setupPiece(new King(Color.WHITE, new Position(7, 4)), whitePlayer);
        setupPiece(new King(Color.BLACK, new Position(0, 4)), blackPlayer);
    }

    private void setupPiece(Piece piece, Player player) {
        player.setPiece(piece);
        board.setPiece(piece);
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (!gameOver) {
            board.printBoard();
            System.out.println(currentPlayer + ", enter your move (e.g., '6 0 5 0'):");

            int fromRow = scanner.nextInt();
            int fromCol = scanner.nextInt();
            int toRow = scanner.nextInt();
            int toCol = scanner.nextInt();

            Position from = new Position(fromRow, fromCol);
            Position to = new Position(toRow, toCol);

            Piece piece = board.getPiece(from);

            if (piece == null || piece.getColor() != currentPlayer.getColor()) {
                System.out.println("Invalid piece selection. Try again.");
                continue;
            }

            List<Position> legalMoves = piece.getLegalMoves(board);

            if (!legalMoves.contains(to)) {
                System.out.println("Illegal move. Try again.");
                continue;
            }

            Piece captured = board.getPiece(to);
            if (captured != null) {
                getOpponent().removePiece(captured);
                System.out.println(currentPlayer + " captured a piece!");
            }

            board.movePiece(from, to);

            // TODO: Check for check, checkmate, stalemate

            switchTurn();
        }

        scanner.close();
    }

    private void switchTurn() {
        currentPlayer = (currentPlayer == whitePlayer) ? blackPlayer : whitePlayer;
    }

    private Player getOpponent() {
        return (currentPlayer == whitePlayer) ? blackPlayer : whitePlayer;
    }
}
