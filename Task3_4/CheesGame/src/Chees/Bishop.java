package Chees;

public class Bishop extends Piece {
    public Bishop(Color color) {
        super(color);
    }

    @Override
    public boolean isValidMove(int fromX, int fromY, int toX, int toY, Square[][] board) {
        // Diagonal movement
        if (Math.abs(toX - fromX) == Math.abs(toY - fromY)) {
            int directionX = (toX > fromX) ? 1 : -1;
            int directionY = (toY > fromY) ? 1 : -1;
            int x = fromX + directionX;
            int y = fromY + directionY;
            while (x != toX && y != toY) {
                if (board[x][y].getPiece() != null) {
                    return false; // Piece in the way
                }
                x += directionX;
                y += directionY;
            }
            return true;
        }

        // Capture movement
        if (Math.abs(toX - fromX) == Math.abs(toY - fromY)) {
            if (board[toX][toY].getPiece() != null && board[toX][toY].getPiece().getColor() != this.getColor()) {
                return true; // Can capture opponent's piece
            }
        }

        return false; // Invalid movement
    }

    @Override
    public boolean isValidMove(int fromX, int fromY, int toX, int toY, Square square) {
        return false;
    }

	@Override
	public boolean isValidMove(int fromX, int fromY, int toX, int toY, Board board) {
		// TODO Auto-generated method stub
		return false;
	}
}

