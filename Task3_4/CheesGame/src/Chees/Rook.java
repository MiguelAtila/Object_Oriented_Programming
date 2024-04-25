package Chees;

public class Rook extends Piece {
    public Rook(Color color) {
        super(color);
    }

    @Override
    public boolean isValidMove(int fromX, int fromY, int toX, int toY, Square[][] board) {
        // Horizontal movement
        if (fromX == toX && fromY != toY) {
            int direction = (toY > fromY) ? 1 : -1;
            int y = fromY + direction;
            while (y != toY) {
                if (board[fromX][y].getPiece() != null) {
                    return false; // Piece in the way
                }
                y += direction;
            }
            return true;
        }

        // Vertical movement
        if (fromY == toY && fromX != toX) {
            int direction = (toX > fromX) ? 1 : -1;
            int x = fromX + direction;
            while (x != toX) {
                if (board[x][fromY].getPiece() != null) {
                    return false; // Piece in the way
                }
                x += direction;
            }
            return true;
        }

        // Capture movement
        if ((fromX == toX && fromY != toY) || (fromY == toY && fromX != toX)) {
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

