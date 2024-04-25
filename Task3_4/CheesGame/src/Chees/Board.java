package Chees;

public class Board {
    private Square[][] board;
    private Color turn;

    // Constructor
    public Board() {
        this.board = new Square[8][8];
        // Initialize the board and place pieces in their initial positions
        initializeBoard();
        placePieces();
        this.turn = Color.White; // Start with White's turn
    }

    // Initialize the board
    private void initializeBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = new Square();
            }
        }
    }

    // Place pieces in their initial positions
    private void placePieces() {
        // Place white pieces
        board[0][0].setPiece(new Rook(Color.White));
        board[0][1].setPiece(new Knight(Color.White));
        board[0][2].setPiece(new Bishop(Color.White));
        board[0][3].setPiece(new Queen(Color.White));
        board[0][4].setPiece(new King(Color.White));
        board[0][5].setPiece(new Bishop(Color.White));
        board[0][6].setPiece(new Knight(Color.White));
        board[0][7].setPiece(new Rook(Color.White));
        for (int i = 0; i < 8; i++) {
            board[1][i].setPiece(new Pawn(Color.White));
        }
        
        // Place black pieces
        board[7][0].setPiece(new Rook(Color.Black));
        board[7][1].setPiece(new Knight(Color.Black));
        board[7][2].setPiece(new Bishop(Color.Black));
        board[7][3].setPiece(new Queen(Color.Black));
        board[7][4].setPiece(new King(Color.Black));
        board[7][5].setPiece(new Bishop(Color.Black));
        board[7][6].setPiece(new Knight(Color.Black));
        board[7][7].setPiece(new Rook(Color.Black));
        for (int i = 0; i < 8; i++) {
            board[6][i].setPiece(new Pawn(Color.Black));
        }
    }

    // Show the board on console
    public void showBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Piece piece = board[i][j].getPiece();
                if (piece == null) {
                    System.out.print("- "); // Empty square
                } else {
                    System.out.print(piece + " "); // Show piece representation
                }
            }
            System.out.println();
        }
    }

    // Get current turn
    public Color getTurn() {
        return turn;
    }

    // Get the square at specified coordinates
    public Square getSquare(int x, int y) {
        return board[x][y];
    }

    // Move a piece from one square to another
    public void movePiece(int fromX, int fromY, int toX, int toY) {
        Piece piece = board[fromX][fromY].getPiece();
        board[fromX][fromY].setPiece(null);
        board[toX][toY].setPiece(piece);
    }

    // Check if a player's king is in check
    public boolean isInCheck(Color color) {
        // Implement logic to check if the king is in check here
        return false;
    }

    // Check if a player's king is in checkmate
    public boolean isInCheckMate(Color color) {
        // Implement logic to check if the king is in checkmate here
        return false;
    }
    
    // Change turn to the other player
    public void changeTurn() {
        turn = (turn == Color.White) ? Color.Black : Color.White;
    }
}

