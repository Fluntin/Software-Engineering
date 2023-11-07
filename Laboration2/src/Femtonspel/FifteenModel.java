package Femtonspel;

import java.util.Random;

class FifteenModel implements Boardgame {

    private String message = "Nothing to show yet"; // default message
    private String[][] board = new String[4][4]; // 4x4 board
    private int emptyRow, emptyCol; // empty square

    // Constructor
    public FifteenModel() {
        initializeBoard();
        shuffleBoard();
    }

    // Initialize the board with numbers 1-15
    private void initializeBoard() {
        int squareNum = 0;
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                squareNum++;
                if (squareNum == 16) {
                    break;
                }
                board[row][col] = Integer.toString(squareNum);
            }
        }
        // Initialize the empty square at the bottom right
        emptyRow = 3;
        emptyCol = 3;
    }

    // Shuffle the board when the game starts
    private void shuffleBoard() {
        Random rand = new Random();
        for (int i = 0; i < 100; i++) {
            int rowChange = rand.nextInt(2) == 0 ? -1 : 1; // ? means if, : means else
            int colChange = rand.nextInt(2) == 0 ? -1 : 1;
            int whichToMove = rand.nextInt(2);

            // Move either row or column
            if (whichToMove == 0) {
                attemptMove(emptyRow + rowChange, emptyCol);
            } else {
                attemptMove(emptyRow, emptyCol + colChange);
            }
        }
    }

    // Attempt to move a tile to the empty square
    private boolean attemptMove(int row, int col) {
        if (isValidMove(row, col) && row >= 0 && row < 4 && col >= 0 && col < 4) {
            board[emptyRow][emptyCol] = board[row][col];
            board[row][col] = null;
            emptyRow = row;
            emptyCol = col;
            message = "OK";
            return true;
        } else {
            message = "Please choose a position next to the empty one!";
            return false;
        }
    }

    // Check if a move is valid
    private boolean isValidMove(int row, int col) {
        // Check if the square is next to the empty square
        return (row - 1 == emptyRow && col == emptyCol) || (row + 1 == emptyRow && col == emptyCol) ||
                (col - 1 == emptyCol && row == emptyRow) || (col + 1 == emptyCol && row == emptyRow);
    }

    @Override
    public boolean move(int row, int col) {
        return attemptMove(row, col);
    }

    @Override
    public String getStatus(int row, int col) {
        return board[row][col];
    }

    @Override
    public String getMessage() {
        return message;
    }
}


