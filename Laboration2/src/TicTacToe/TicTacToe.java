package TicTacToe;

class TicTacToe implements Boardgame {

  private String currentMessage = "";
  private String[][] board = new String[3][3];
  private String player1 = "X";
  private String player2 = "O";
  private boolean player1Turn = true; // true = player1
  private int numMoves = 0; // once this reaches 9, start "flyttfas".

  // För flyttfasen
  private boolean selected = false;
  private int iCoord = 0;
  private int jCoord = 0;

  public boolean move(int i, int j) {
    if (numMoves < 9) {
      return preFlyttFas(i, j);
    }
    return FlyttFas(i, j);
  }

  boolean preFlyttFas(int i, int j) {
    if (board[i][j] != null) {
      currentMessage = "Failed to perform move, something's there!";
      return false;
    }
    else {
      if (player1Turn) {
        board[i][j] = player1;
        player1Turn = false;
      } else {
        board[i][j] = player2;
        player1Turn = true;
      }
      currentMessage = "Succeeded in making move";
    }
    numMoves++;
    return true;
  }

  boolean FlyttFas(int i, int j) {
    if (selected) {
      if (!player1Turn && board[i][j] == player1) {
        /* If it's player 2's turn, they have already selected
        a square and have now chosen a square containing an 'X': */
        board[i][j] = player2;
        board[iCoord][jCoord] = player1;
        player1Turn = true;
      }
      else if (player1Turn && board[i][j] == player2) {
        board[i][j] = player1;
        board[iCoord][jCoord] = player2;
        player1Turn = false;
      }
      else {
        currentMessage = "Wrong kind of choice";
        return false;
      }
      currentMessage = "Dropped";
      selected = false;
    }
    else {
      if ((!player1Turn && board[i][j] == player2) ||
        (player1Turn && board[i][j] == player1)) {
        /* If it's player 2's turn and player 2 has correctly
        chosen a square containing an 'O': */
        selected = true;
        iCoord = i;
        jCoord = j;
      }
        else {
        currentMessage = "Wrong kind of choice";
        return false;
      }
      currentMessage = "Chosen";
    }
    return true;
  }

  public String getStatus(int i, int j) {
    return board[i][j];
  }

  public String getMessage() {
    return currentMessage;
  }

}
