import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class VotesInput extends JFrame implements ActionListener {

    VotesModel mod;

    VotesInput (VotesModel m) {
	mod = m;
	int n = mod.getN();
	setSize(200,200);
	setLayout(new GridLayout(n,1));
	for (int i=0; i<n; i++) {
	    NumberButton b = new NumberButton(mod.getChoc(i),i);
	    b.setBackground(mod.getCol(i));
	    add(b);
	    b.addActionListener(this);
	}
	setVisible(true);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void actionPerformed (ActionEvent e) {
	NumberButton b = (NumberButton) e.getSource();
	int m = b.number;
	mod.vote(m); // Update model with new vote
    }

    // To test VotesModel and VotesInput only, without the views
    public static void main(String[] u) {
	VotesModel mod = new VotesModel();
	VotesInput votes = new VotesInput(mod);
    }
}
