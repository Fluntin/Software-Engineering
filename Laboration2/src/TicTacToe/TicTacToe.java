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
             // If a square is already selected, check if the player can perform a valid swap
            if (!isPlayerXTurn && gameBoard[row][column] == playerX) {
                // If it's Player O's turn, they have already selected
                // a square and have now chosen a square containing an 'X'. Swap the symbols.
                gameBoard[row][column] = playerO;
                gameBoard[selectedRow][selectedColumn] = playerX;
                isPlayerXTurn = true; // Toggle to the other player X's turn

            } else if (isPlayerXTurn && gameBoard[row][column] == playerO) {
                 // If it's Player X's turn, they have already selected a square
                // and have now chosen a square containing an 'O'. Swap the symbols.
                gameBoard[row][column] = playerX;
                gameBoard[selectedRow][selectedColumn] = playerO;
                isPlayerXTurn = false; // Toggle to Player O's turn
            } else {
                // If the player's choice is invalid (e.g., not a valid swap),
                // set an error message and return false.
                currentMessage = "Wrong kind of choice";
                return false;
            }
            currentMessage = "Dropped"; // Set a message indicating that the swap was successful.
            isSquareSelected = false; // Reset the square selection flag.
        } else {
            // If no square is selected, check if the player selects a square containing
            // their opponent's symbol. If so, set the square as selected for a potential swap.
            if ((!isPlayerXTurn && gameBoard[row][column] == playerO) ||
                    (isPlayerXTurn && gameBoard[row][column] == playerX)) {
                // If it's Player O's turn and Player O has correctly
                // chosen a square containing an 'O':
                isSquareSelected = true;
                selectedRow = row;
                selectedColumn = column;
            } else {
                 // If the player's choice is invalid (e.g., not a valid selection),
                // set an error message and return false.
                currentMessage = "Wrong kind of choice";
                return false;
            }
            currentMessage = "Chosen"; // Set a message indicating a successful selection.
        }
        return true; // Return true to indicate that the move was successful.
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

