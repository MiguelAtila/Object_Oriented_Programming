package Chees;

public class King extends Piece {
    public King(Color color) {
        super(color);
    }

    @Override
    public boolean isValidMove(int fromX, int fromY, int toX, int toY, Square[][] board) {
        int deltaX = Math.abs(toX - fromX);
        int deltaY = Math.abs(toY - fromY);

        // Basic king movement (one square in any direction)
        if ((deltaX == 1 && deltaY == 0) || (deltaX == 0 && deltaY == 1) || (deltaX == 1 && deltaY == 1)) {
            return true;
        }

        // Castling movement
        if (deltaX == 0 && deltaY == 2) {
            // Check that king and involved rook haven't moved
            // and there are no pieces between them
            if (fromY == 4 && ((toY == 2 && board[fromX][0].getPiece() instanceof Rook && !board[fromX][0].getPiece().hasMoved()) ||
                    (toY == 6 && board[fromX][7].getPiece() instanceof Rook && !board[fromX][7].getPiece().hasMoved()))) {
                // Check that path between king and rook is clear
                int direction = (toY == 2) ? -1 : 1;
                int column = (toY == 2) ? 1 : 6;
                while (fromY != column) {
                    if (board[fromX][fromY + direction].getPiece() != null) {
                        return false; // Piece in the way
                    }
                    fromY += direction;
                }
                return true;
            }
        }

        // Capture movement
        if ((deltaX == 1 && deltaY == 0) || (deltaX == 0 && deltaY == 1) || (deltaX == 1 && deltaY == 1)) {
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

