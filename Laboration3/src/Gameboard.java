import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class Gameboard extends JPanel {

	// Strange that its not working with .gif, but .jpg works fine.
	// This could be because of the version of Java that I am using...
	private Icon[] icons = {
		new ImageIcon(getClass().getResource("rock.jpg")),
		new ImageIcon(getClass().getResource("scissors.jpg")),
		new ImageIcon(getClass().getResource("paper.jpg"))
	};

    private JButton[] buttons = new JButton[3];
    private JButton lastPlayed; // remembers last chosen button/gesture
    private String[] texts = {"STEN", "SAX", "PASE"};
    private JLabel upperMess, lowerMess, scorelabel;
    private int score;
    private Color bgcolor;
    private HashMap<String,JButton> map = new HashMap<String,JButton>();


    // Constructor that builds the board, used for computers board
	private JLabel playerScoreLabel, computerScoreLabel;
	private int playerScore = 0;
	private int computerScore = 0;

    Gameboard(String name) {
		setLayout(new GridLayout(5,1));

	// Upper JPanel holds players name and last gesture played
	JPanel upper = new JPanel();
	upper.setLayout(new GridLayout(2,1));
	upper.add(new JLabel(name, JLabel.CENTER)); 
	upperMess = new JLabel("RPS", JLabel.CENTER);
	upper.add(upperMess);
	add(upper);

	// Lower JPanel has messages about the game and score
	JPanel lower = new JPanel();
	lower.setLayout(new GridLayout(2,1));
	lowerMess = new JLabel("win/lose/draw", JLabel.CENTER);
	playerScoreLabel = new JLabel("", JLabel.CENTER); // Player's score label
    computerScoreLabel = new JLabel("", JLabel.CENTER); // Computer's score label
    lower.add(lowerMess);
    lower.add(playerScoreLabel);
    lower.add(computerScoreLabel);
    add(lower);

	for (int i = 0; i<3; i++){
	    buttons[i] = new JButton(icons[i]);
	    buttons[i].setActionCommand(texts[i]);
	    add(buttons[i]);
	    // Store each button in a map with its text as key. 
            // Enables us to retrieve the button from a textvalue. 
	    map.put(texts[i],buttons[i]);
	}

	add(lower); // added after buttons
	bgcolor = buttons[0].getBackground();
	lastPlayed = buttons[0]; // arbitrary value at start
    }


    // Contructor for players board, puts listener on buttons
    Gameboard(String name, ActionListener listener) {
	this(name); // call other constructor to build the board
	for (int i = 0; i<3; i++)
	    buttons[i].addActionListener(listener);
    }

    // reset yellow color
    void resetColor() {
	lastPlayed.setBackground(bgcolor);
    }

    void setUpper(String r) {
	upperMess.setText(r);
    }

    void setLower(String r) {
	lowerMess.setText(r);
    }

   // remember last chosen JButton and mark it yellow
    void markPlayed(String r) {
	lastPlayed = map.get(r); 
	lastPlayed.setBackground(Color.yellow);
    }

    // or use JButton as parameter
    void markPlayed(JButton b) {
	lastPlayed = b; 
	lastPlayed.setBackground(Color.yellow);
    }

    // add one point and display new score
    void wins(boolean playerWins, boolean computerWins) {
		if (playerWins) {
			playerScore++;
		}
		if (computerWins) {
			computerScore++;
		}
		playerScoreLabel.setText("Player: " + playerScore); // Update player's score label
		computerScoreLabel.setText("Computer: " + computerScore); // Update computer's score label
	}

	

}
