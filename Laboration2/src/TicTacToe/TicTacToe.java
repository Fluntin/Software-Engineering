package TicTacToe;

public class TicTacToe implements Boardgame {
    private String currentMessage = "";
    private String[][] gameBoard = new String[3][3];
    private String playerX = "X";
    private String playerO = "O";
    private boolean isPlayerXTurn = true;
    private int totalMoves = 0; // Once this reaches 9, we start the "move phase".

    // For the "move phase"
    private boolean isSquareSelected = false;
    private int selectedRow = 0;
    private int selectedColumn = 0;

    @Override
    public boolean move(int row, int column) {
        if (totalMoves < 6) {
            return preMovePhase(row, column);
        }
        return movePhase(row, column);
    }


    //This method is used during the "pre-move phase" of the game, where players take turns
    // placing their symbols (X or O) on the game board.
    private boolean preMovePhase(int row, int column) {
        if (gameBoard[row][column] != null) {
            // Check if the selected square is already occupied by a symbol.
            // If it is, set an error message and return false, indicating that the move failed.
            currentMessage = "Failed to perform move, something's already there!";
            return false;
        } else {
            // If the selected square is empty, assign the current player's symbol to it.
            if (isPlayerXTurn) {
                gameBoard[row][column] = playerX;
                isPlayerXTurn = false; // Toggle to the other player's turn.
            } else {
                gameBoard[row][column] = playerO;
                isPlayerXTurn = true; // Toggle to the other player's turn.
            }
            currentMessage = "Succeeded in making a move";
        }
        totalMoves++; // Increment the total number of moves.
        return true; // Return true to indicate that the move was successful
    }

    // This method handles the "move phase" of the game, where players can swap squares
    // if they select a square containing their opponent's symbol.
    private boolean movePhase(int row, int column) {
        if (isSquareSelected) {
            // Check if the selected square is empty and adjacent to the previously selected square
            if (gameBoard[row][column] == null && isAdjacent(row, column, selectedRow, selectedColumn)) {
                // Move the player's symbol to the new square
                gameBoard[row][column] = isPlayerXTurn ? playerX : playerO;
                gameBoard[selectedRow][selectedColumn] = null;
    
                // Toggle the turn
                isPlayerXTurn = !isPlayerXTurn;
                currentMessage = "Move successful";
                isSquareSelected = false; // Reset the square selection flag.
            } else {
                currentMessage = "Invalid move";
                return false;
            }
        } else {
            // Select a square only if it contains the player's symbol
            if ((isPlayerXTurn && gameBoard[row][column] == playerX) ||
                (!isPlayerXTurn && gameBoard[row][column] == playerO)) {
                isSquareSelected = true;
                selectedRow = row;
                selectedColumn = column;
                currentMessage = "Square selected";
            } else {
                currentMessage = "Invalid selection";
                return false;
            }
        }
        return true;
    }
    
    // Helper method to check if two squares are adjacent
    private boolean isAdjacent(int row1, int col1, int row2, int col2) {
        return Math.abs(row1 - row2) <= 1 && Math.abs(col1 - col2) <= 1;
    }
    

    @Override
    public String getStatus(int row, int column) {
        return gameBoard[row][column];
    }

    @Override
    public String getMessage() {
        return currentMessage;
    }
}

