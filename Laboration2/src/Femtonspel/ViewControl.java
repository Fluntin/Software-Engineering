package Femtonspel;

import java.awt.event.*;
import javax.swing.*;

//Class handles the graphical user interface (GUI) for the game using Swing.
class ViewControl extends JFrame {
  // All the private variables are declared here.
  // These variables store game information and are used to update the GUI.
  private Boardgame game; // game is an interface.
  private int boardSize; // Size of the game board.
  private Square[][] gameBoard; // 2D array of Square objects.
  private JLabel messageLabel = new JLabel(); // To display messages to the user.
  JPanel gamePanel = new JPanel(); // So i can hold game's graphical components.

  // This is the main method -> Program starts here.
  public static void main(String[] args) {
    // First we create a new instance of the game.
    // Create an instance of the FifteenModel class to represent the game logic.
    //Boardgame game = new FifteenModel();
    Boardgame game = new NewMockGame();
    // Then we create a new instance of the ViewControl class.
    // We need to åass the game logic and the size of the game board.
    new ViewControl(game, 4);
  }

  // Constructor for the ViewControl class.
  // Responsible for setting up the GUI for the game.
  ViewControl(Boardgame gameInstance, int boardSize) {
    // Initialze the instance variables with the values passed to the constructor.
    this.game = gameInstance;
    this.boardSize = boardSize;

    // Estetic stuff...
    JFrame frame = new JFrame();
    frame.setSize(700, 700);

    // Set the layout of the gamePanel to null.
    // This allows me to set the position of the game components manually.
    // Absolute positioning -> meaning that the position of the components is set manually.
    gamePanel.setLayout(null);
    frame.add(gamePanel);

    createGameButtons();

    // Initialize the text on the game buttons based on the current game state.
    // This is done by calling the updateGameStatus method.
    updateGameStatus();
    messageLabel.setBounds(100, 50, 1000, 50);
    gamePanel.add(messageLabel); // Add the messageLabel to the gamePanel.

    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

// This method creates the game buttons.  
  void createGameButtons() {

    // Initialize the gameBoard array.
    // Holds the Square objects that represent the game buttons!
    gameBoard = new Square[boardSize][boardSize];

    for (int i = 0; i < boardSize; i++) {
      for (int j = 0; j < boardSize; j++) {
        
        // Create a new Square object. With an epmty string as text.
        Square square = new Square(i, j, " ");

        // Add an action listener to the Square object.
        // This way we can listen for when the user clicks on the Square object!
        square.addActionListener(new ActionListener() {

          // When a square is clicked, the actionPerformed method is called.
          /// We send the row and column index of the square to the move method.
          public void actionPerformed(ActionEvent e) {
            game.move(square.getRowIndex(), square.getColIndex());

            // Now I need to update the GUI and the messageLabel!
            updateGameStatus();
            updateMessageLabel();
          }
        });

        gamePanel.add(square); // Add the Square object to the gamePanel.
        square.setBounds(j * 100 + 100, i * 100 + 100, 100, 100);
        gameBoard[i][j] = square; // Add the Square object to the gameBoard array.
      }
    }
  }

  // This method updates the text on the game buttons.
  // The game buttons text is based on the current game state.
  void updateGameStatus() {
    String status; // Holds the text that will be displayed on the game buttons.
    for (int i = 0; i < boardSize; i++) {
      for (int j = 0; j < boardSize; j++) {
        status = game.getStatus(i, j); // Get the text that will be displayed on the game button.
        gameBoard[i][j].setText(status); // Set the text on the game button.
      }
    }
  }

  // This method updates the messageLabel.
  void updateMessageLabel() {
    String message = game.getMessage();
    messageLabel.setText(message);
  }
}


