package TicTacToe;
import java.awt.event.*;
import javax.swing.*;

//Class handles the graphical user interface (GUI) for the game using Swing.
class ViewControl extends JFrame {

  private Boardgame game;
  private int boardSize;
  private Square[][] gameBoard;
  private JLabel messageLabel = new JLabel();
  JPanel gamePanel = new JPanel();

  public static void main(String[] args) {
    Boardgame game = new TicTacToe();
    new ViewControl(game, 3);
  }

  ViewControl(Boardgame gameInstance, int boardSize) {
    this.game = gameInstance;
    this.boardSize = boardSize;

    JFrame frame = new JFrame();
    frame.setSize(700, 700);

    gamePanel.setLayout(null);
    frame.add(gamePanel);

    createGameButtons();

    updateGameStatus();
    messageLabel.setBounds(100, 50, 1000, 50);
    gamePanel.add(messageLabel);

    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  void createGameButtons() {
    gameBoard = new Square[boardSize][boardSize];

    for (int i = 0; i < boardSize; i++) {
      for (int j = 0; j < boardSize; j++) {
        Square square = new Square(i, j, " ");
        square.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            game.move(square.getRowIndex(), square.getColIndex());
            updateGameStatus();
            updateMessageLabel();
          }
        });
        gamePanel.add(square);
        square.setBounds(j * 100 + 100, i * 100 + 100, 100, 100);
        gameBoard[i][j] = square;
      }
    }
  }

  void updateGameStatus() {
    String status;
    for (int i = 0; i < boardSize; i++) {
      for (int j = 0; j < boardSize; j++) {
        status = game.getStatus(i, j);
        gameBoard[i][j].setText(status);
      }
    }
  }

  void updateMessageLabel() {
    String message = game.getMessage();
    messageLabel.setText(message);
  }
}


