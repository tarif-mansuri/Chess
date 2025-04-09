package model;

import model.pieces.King;
import model.pieces.Piece;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private Color color;
    private List<Piece> pieces;

    public Player(Color color) {
        this.color = color;
        this.pieces = new ArrayList<>();
    }
    public Color getColor() {
        return color;
    }
    public List<Piece> getPiece() {
        return pieces;
    }

    public void setPiece(Piece piece) {
        this.pieces.add(piece);
    }

    public void removePiece(Piece piece) {
        this.pieces.remove(piece);
    }
    public Piece getKingPiece() {
        for (Piece piece : pieces) {
            if (piece instanceof King) {
                return piece;
            }
        }
        return null;
    }

    public String toString() {
        return color+" Player";
    }
}
