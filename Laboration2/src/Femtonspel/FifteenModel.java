package Femtonspel;

import java.util.Random;

// The FifteenModel class implements the Boardgame interface.
// This means that FifteenModel must provide concrete implementations 
// for all the methods declared in the Boardgame interface.

class FifteenModel implements Boardgame {

    private String message = "Nothing to show yet"; // default message
    private String[][] board = new String[4][4]; // 4x4 board
    private int emptyRow, emptyCol; // empty square

    // Constructor
    public FifteenModel() {
        initializeBoard(); // Initialize the board with numbers 1-15.
        shuffleBoard(); // Shuffle the board when the game starts.
    }

    // Initialize the board with numbers 1-15
    private void initializeBoard() {
        int squareNum = 0; // The number to put in the square
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                squareNum++;
                if (squareNum == 16) {
                    break;
                }
                board[row][col] = Integer.toString(squareNum); // Convert int to String!
            }
        }
        // Initialize the empty square at the bottom right corner.
        emptyRow = 3;
        emptyCol = 3;
    }

    // Shuffle the board when the game starts
    private void shuffleBoard() {
        Random rand = new Random(); // Random instance creation, used to shuffle the board.
        for (int i = 0; i < 100; i++) { // Shuffle the board 100 times.

            // Ternary Operators!
            // ? means if, : means else

            // Randomly decide if the empty square should move up/down or left/right
            int rowChange = rand.nextInt(2) == 0 ? -1 : 1; // Decide randomly whether to move a row up (-1) or down (+1).
            int colChange = rand.nextInt(2) == 0 ? -1 : 1; // Decide randomly whether to move a column left (-1) or right (+1).
            int whichToMove = rand.nextInt(2); // Decide randomly whether to move a row or a column.

            // EXAMPLE:
            // rand.nextInt(2) returns 0.
            // whichToMove is now 0.
            // rowChange is now -1.
            // colChange is now 1.
            // The empty square will move diagonally up-right.
        
            // Move either row or column
            if (whichToMove == 0) {
                // Move a row -> If whichToMove is 0, try to move a tile in the row direction.
                attemptMove(emptyRow + rowChange, emptyCol); // Attempt to move a tile to the empty square.
            } else {
                // Move a column -> If whichToMove is 1, try to move a tile in the column direction.
                attemptMove(emptyRow, emptyCol + colChange); // Attempt to move a tile to the empty square.
            }
        }
    }

    // Attempt to move a tile to the empty square
    // This is a private helper method, it can only be called from within the FifteenModel class.
    private boolean attemptMove(int row, int col) {

        // checks if tile is next to empty square
        // This is manly for the text version of the game.
        if (isValidMove(row, col) && row >= 0 && row < 4 && col >= 0 && col < 4) { 
            board[emptyRow][emptyCol] = board[row][col]; // Move the tile to the empty square.
            board[row][col] = null; // Remove the tile from its previous position making it empty!
            emptyRow = row; // Update the empty square's row position.
            emptyCol = col; // Update the empty square's column position.
            message = "OK"; // Update the message.
            return true; // Return true to indicate that the move was successful.
        } else {
            // We know that the move was not successful, so we update the message and return false.
            message = "Please choose a position next to the empty one!";
            return false; // Return false to indicate that the move was not successful.
        }
    }

    // Check if a move is valid
    private boolean isValidMove(int row, int col) {
        // Check if the square is next to the empty square.
        // The logic is that we check if the square is either above, below, to the left or to the right of the empty square.
        return (row - 1 == emptyRow && col == emptyCol) || (row + 1 == emptyRow && col == emptyCol) ||
                (col - 1 == emptyCol && row == emptyRow) || (col + 1 == emptyCol && row == emptyRow);
    }

    // The move method is declared in the Boardgame interface.
    @Override
    public boolean move(int row, int col) {
        return attemptMove(row, col);
    }

    // The getStatus method is required by the Boardgame interface.
    @Override
    public String getStatus(int row, int col) {
        return board[row][col];
    }

    // The getMessage method is required by the Boardgame interface.
    @Override
    public String getMessage() {
        return message;
    }

    // This methods can be called from any other class. 
    // It's part of the Boardgame interface, so it must be public to allow for polymorphic behavior.
}

// Polymorphic behavior in object-oriented programming refers to the ability of a single interface
// to be used for different underlying forms (data types). 

// In Java, polymorphism allows one interface to be used for a general class of actions, 
// and specific action is determined at runtime.


