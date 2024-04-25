package Chees;
import java.util.Scanner;

public class CheesMain {
    // Method to convert column letters to integer numbers
    public static int getColumnNumber(char column) {
        return Character.toLowerCase(column) - 'a';
    }
    
    // Method to convert row numbers to board indices
    public static int getRowNumber(int row) {
        return 8 - row;
    }

    public static void main(String[] args) {
        // Create a chess board
        Board board = new Board();

        // Show the initial board
        System.out.println("Starting board:");
        board.showBoard();

        // Create a scanner to read user input
        Scanner scanner = new Scanner(System.in);

        // Main game loop
        while (true) {
            // Ask the player to enter their move
            System.out.println("Player turn " + board.getTurn());
            System.out.println("Enter your move (e.g. 'a2 a4'): ");
            String input = scanner.nextLine();
            String[] portion = input.split(" ");

            // Check if the input is valid
            if (portion.length != 2) {
                System.out.println("Invalid movement. Please enter your move in the 'from-to' format.");
                continue;
            }

            // Convert the input to board coordinates
            char fromColumn = portion[0].charAt(0);
            int fromRow = Character.getNumericValue(portion[0].charAt(1));

            char toColumn = portion[1].charAt(0);
            int toRow = Character.getNumericValue(portion[1].charAt(1));

            int fromX = getColumnNumber(fromColumn);
            int fromY = getRowNumber(fromRow);
            int toX = getColumnNumber(toColumn);
            int toY = getRowNumber(toRow);

            // Check if the coordinates are within the board
            if (fromX < 0 || fromX >= 8 || fromY < 0 || fromY >= 8 || toX < 0 || toX >= 8 || toY < 0 || toY >= 8) {
                System.out.println("Coordinates out of range. Please enter valid coordinates.");
                continue;
            }

            // Get the piece on the starting square
            Piece piece = board.getSquare(fromX, fromY).getPiece();
            if (piece == null) {
                System.out.println("There is no piece on the starting square. Try again.");
                continue;
            }

            // Check if the move is valid for that piece
            if (!piece.isValidMove(fromX, fromY, toX, toY, board)) {
                System.out.println("Movement not valid for that piece. Try again.");
                continue;
            }

            // Make the move on the board
            board.movePiece(fromX, fromY, toX, toY);

            // Check if the king is in check
            if (board.isInCheck(board.getTurn())) {
                System.out.println("Check!");
            }

            // Check for checkmate
            if (board.isInCheckMate(board.getTurn())) {
                System.out.println("Checkmate! The player " + board.getTurn() + " has lost.");
                break;
            }

            // Show the board after the move
            System.out.println("Board after move:");
            board.showBoard();

            // Change player turn
            board.changeTurn();
        }

        // Close the scanner
        scanner.close();
    }
}


