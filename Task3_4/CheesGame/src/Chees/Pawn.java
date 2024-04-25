package Chees;

public class Pawn extends Piece {
    private boolean hasMoved;

    public Pawn(Color color) {
        super(color);
        this.hasMoved = false;
    }

    @Override
    public boolean isValidMove(int fromX, int fromY, int toX, int toY, Square[][] board) {
        int direction = (this.getColor() == Color.White) ? 1 : -1;
        int startingRow = (this.getColor() == Color.White) ? 1 : 6;

        // Moving forward
        if (fromX == toX && fromY + direction == toY && board[toX][toY].getPiece() == null) {
            this.hasMoved = true;
            return true;
        }

        // Initial double move
        if (fromX == toX && fromY + 2 * direction == toY && fromY == startingRow && board[toX][toY].getPiece() == null
                && board[toX][toY - direction].getPiece() == null) {
            this.hasMoved = true;
            return true;
        }

        // Capturing diagonally
        if (Math.abs(toX - fromX) == 1 && fromY + direction == toY
                && board[toX][toY].getPiece() != null
                && board[toX][toY].getPiece().getColor() != this.getColor()) {
            this.hasMoved = true;
            return true;
        }

        return false;
    }

    public boolean hasMoved() {
        return hasMoved;
    }

	@Override
	public boolean isValidMove(int fromX, int fromY, int toX, int toY, Board board) {
		// TODO Auto-generated method stub
		return false;
	}
}




