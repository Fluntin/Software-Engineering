package TicTacToe;

public class TicTacToe implements Boardgame {
    private String currentMessage = "";
    private String[][] gameBoard = new String[3][3];
    private String playerX = "X";
    private String playerO = "O";
    private boolean isPlayerXTurn = true;
    private int totalMoves = 0; // Once this reaches 9, start the "move phase".

    // For the "move phase"
    private boolean isSquareSelected = false;
    private int selectedRow = 0;
    private int selectedColumn = 0;

    @Override
    public boolean move(int row, int column) {
        if (totalMoves < 9) {
            return preMovePhase(row, column);
        }
        return movePhase(row, column);
    }

    private boolean preMovePhase(int row, int column) {
        if (gameBoard[row][column] != null) {
            currentMessage = "Failed to perform move, something's already there!";
            return false;
        } else {
            if (isPlayerXTurn) {
                gameBoard[row][column] = playerX;
                isPlayerXTurn = false;
            } else {
                gameBoard[row][column] = playerO;
                isPlayerXTurn = true;
            }
            currentMessage = "Succeeded in making a move";
        }
        totalMoves++;
        return true;
    }

    private boolean movePhase(int row, int column) {
        if (isSquareSelected) {
            if (!isPlayerXTurn && gameBoard[row][column] == playerX) {
                // If it's Player O's turn, they have already selected
                // a square and have now chosen a square containing an 'X':
                gameBoard[row][column] = playerO;
                gameBoard[selectedRow][selectedColumn] = playerX;
                isPlayerXTurn = true;
            } else if (isPlayerXTurn && gameBoard[row][column] == playerO) {
                gameBoard[row][column] = playerX;
                gameBoard[selectedRow][selectedColumn] = playerO;
                isPlayerXTurn = false;
            } else {
                currentMessage = "Wrong kind of choice";
                return false;
            }
            currentMessage = "Dropped";
            isSquareSelected = false;
        } else {
            if ((!isPlayerXTurn && gameBoard[row][column] == playerO) ||
                    (isPlayerXTurn && gameBoard[row][column] == playerX)) {
                // If it's Player O's turn and Player O has correctly
                // chosen a square containing an 'O':
                isSquareSelected = true;
                selectedRow = row;
                selectedColumn = column;
            } else {
                currentMessage = "Wrong kind of choice";
                return false;
            }
            currentMessage = "Chosen";
        }
        return true;
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

