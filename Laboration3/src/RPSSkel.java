import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;
import java.io.*;

//-------------------------------------------------------------------------------------------------
// This whole code is all about the GUI and the Game Logic.
// The GUI is created using the Java Swing library.
// The game logic is implemented using the ActionListener interface.
// The ActionListener interface is used to handle button clicks (player's choices) and manages the game logic.
//-------------------------------------------------------------------------------------------------

class RPSSkel extends JFrame implements ActionListener {

    //-------------------------------------------------------------------------------------------------
	// Just instance variables, no changes needed
    JFrame frame = new JFrame();
    Gameboard playerBoard, computerBoard;
    int turnCounter = 0;
    Socket networkSocket;
    BufferedReader inputReader;
    PrintWriter outputWriter;
    JButton closeButton;
    String playerChoice;
    String computerChoice;

    //-------------------------------------------------------------------------------------------------
    // Method that updates the game user interface.
	// Games user interface with two gameboards, one for the player and one for the computer.
	// It should take care of the game logic and update the gameboards accordingly.
	// Take 3 arguments: the game state, the computer's result and a boolean that determines if the choices should be set.
    //-------------------------------------------------------------------------------------------------
    void updateGameUI(String gameState, String computersResult, boolean setChoices) {
        playerBoard.setLower(gameState);
        computerBoard.setLower(computersResult);
        if (setChoices) {
            playerBoard.setUpper(playerChoice);
            computerBoard.setUpper(computerChoice);
        }
    }

    //-------------------------------------------------------------------------------------------------
	// Method that determines the winner of the game and updates the gameboards accordingly.
	// There are 3 cases: draw, player wins or computer wins.
	// We can group the cases by using if-else statements.
    //-------------------------------------------------------------------------------------------------
    void determineWinner() {
        if (playerChoice.equals(computerChoice)) {
            updateGameUI("DRAW", "DRAW", true);
        } else if ((playerChoice.equals("STEN") && computerChoice.equals("SAX")) ||
                   (playerChoice.equals("PASE") && computerChoice.equals("STEN")) ||
                   (playerChoice.equals("SAX") && computerChoice.equals("PASE"))) {
            updateGameUI("WINS", "LOSES", true);
            playerBoard.wins(true, false); // Player wins, computer loses
        } else {
            updateGameUI("LOSES", "WINS", true);
            playerBoard.wins(false, true); // Player loses, computer wins
        }
    }
    
    //-------------------------------------------------------------------------------------------------
	// When event occurs, this method is called.
	// This method handles the game logic based on turnCounter -> keeps track of the game state.
    // The turnCounter is incremented by 1 each time the method is called.
    //-------------------------------------------------------------------------------------------------
    public void actionPerformed(ActionEvent e) {
        if (turnCounter == 0) {
            updateGameUI("ONE...", "ONE...", false);
            playerBoard.resetColor();
            playerBoard.setUpper("RPS");
            computerBoard.resetColor();
            computerBoard.setUpper("RPS");
        } else if (turnCounter == 1) {
            updateGameUI("TWO...", "TWO...", false);
        } else if (turnCounter == 2) {
            playerChoice = e.getActionCommand();
            playGame();
            playerBoard.markPlayed(playerChoice);
            computerBoard.markPlayed(computerChoice);
            determineWinner();
            turnCounter = 0;
            return;
        } else {
            System.exit(0);
        }
        turnCounter++;
    }
    //-------------------------------------------------------------------------------------------------
	// Method that creates a close button.
	// When the button is pressed, the program should exit.
	// Here I have created a button and added an action listener to it!
    //-------------------------------------------------------------------------------------------------
    void createCloseButton() {
        closeButton = new JButton("Close");
        ActionListener closeButtonListener = (new ActionListener() {
            public void actionPerformed(ActionEvent e) {
				System.out.println("Close button clicked");
                System.exit(0);
            }
        });
        closeButton.addActionListener(closeButtonListener);
    }
    //-------------------------------------------------------------------------------------------------
	// Method that sets up the gameboard.
	// It should add the gameboards to the frame and set the size of the frame.
	// I need to make this more esthetically pleasing...
    //-------------------------------------------------------------------------------------------------
	void setupGameBoard() {
		// Create a JPanel to hold the game boards side by side
		JPanel gamePanel = new JPanel(new GridLayout(1, 2));
		gamePanel.add(playerBoard);
		gamePanel.add(computerBoard);
		frame.add(gamePanel, BorderLayout.CENTER); // Add the game panel to the center
		frame.add(closeButton, BorderLayout.SOUTH); // Add the "Close" button to the bottom
		frame.setSize(1000, 1250);
		frame.setVisible(true);		
	}
	
    //-------------------------------------------------------------------------------------------------
	// Constructor for the class.
	// It should create a frame, create a close button, create two gameboard instances one for the player and one for the computer.
    // Then it should set up the gameboard.
	// It should also create a socket, a buffered reader and a print writer.
    //-------------------------------------------------------------------------------------------------
    RPSSkel() {
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        createCloseButton();
        playerBoard = new Gameboard("You", this);
        computerBoard = new Gameboard("Computer");
        setupGameBoard();
        try {
            networkSocket = new Socket("localhost", 4713); // Socket for communication with the server on port 4713 is created.
            inputReader = new BufferedReader(new InputStreamReader(networkSocket.getInputStream())); // BufferedReader is created to read input from the server.
            outputWriter = new PrintWriter(networkSocket.getOutputStream()); // PrintWriter is created to send input to the server.
            outputWriter.println("Player 1"); // We send the player name to the server.
            outputWriter.flush(); // We need to flush the output stream to send the message immediately.
            System.out.println(inputReader.readLine()); // We print the server's response.
        } 
        //-------------------------------------------------------------------------------------------------
        // catch (IOException e) is used to catch any exceptions that might occur.
        // This is done to prevent the program from crashing.
        //-------------------------------------------------------------------------------------------------
        catch (IOException e) {
            System.out.println(e);
        }
    }

    //-------------------------------------------------------------------------------------------------
	// Method that plays the game.
	// It should send the player choice to the server and receive the computer choice from the server.
    //-------------------------------------------------------------------------------------------------
    void playGame() {
        try {
            outputWriter.println(playerChoice);
            outputWriter.flush();
            computerChoice = inputReader.readLine();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

	// Main method that creates an instance of the class.
    public static void main(String[] args) {
        new RPSSkel();
    }
}
/*******************************************
This class serves as the user interface and game logic controller.
It extends JFrame to create a graphical user interface (GUI) for the game.
It creates two Gameboard instances, one for the player and one for the computer.
It sets up the GUI components, such as buttons, labels, and the "Close" button.
It establishes a socket connection to the server, creating a BufferedReader and PrintWriter for communication.
It implements the ActionListener interface to handle button clicks (player's choices) and manages the game logic.
The updateGameUI method updates the GUI based on the game state.
The determineWinner method determines the winner of each round.
The playGame method sends the player's choice to the server and receives the computer's choice.
The main method creates an instance of RPSSkel, initiating the game.
*******************************************/
