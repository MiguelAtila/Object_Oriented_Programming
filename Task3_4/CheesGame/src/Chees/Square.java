package Chees;

public class Square {
    private Piece piece;

    // Constructor
    public Square() {
        this.piece = null;
    }

    // Get the piece on the square
    public Piece getPiece() {
        return piece;
    }

    // Set the piece on the square
    public void setPiece(Piece piece) {
        this.piece = piece;
    }
}
