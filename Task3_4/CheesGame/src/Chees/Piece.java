package Chees;

public abstract class Piece {
    private Color color;

    public Piece(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public abstract boolean isValidMove(int fromX, int fromY, int toX, int toY, Board board);

	public boolean isValidMove(int fromX, int fromY, int toX, int toY, Square[][] board) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isValidMove(int fromX, int fromY, int toX, int toY, Square square) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean hasMoved() {
		// TODO Auto-generated method stub
		return false;
	}
}
