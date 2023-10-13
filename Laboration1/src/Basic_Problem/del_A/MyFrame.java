package Basic_Problem.del_A;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener {

    private MyButton buttonTop;
    private MyButton buttonBottom;

    public MyFrame(String title) {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(777, 333);
        setLayout(new GridBagLayout());  
        
        GridBagConstraints constraints = new GridBagConstraints();  
        constraints.gridwidth = GridBagConstraints.REMAINDER; 
        constraints.fill = GridBagConstraints.HORIZONTAL;  
        constraints.insets = new Insets(10, 0, 10, 0); 
        
        buttonTop = new MyButton(); // Create a new MyButton object
        buttonTop.addActionListener(this); // Add an action listener to the button
        add(buttonTop, constraints);  // Add the button to the frame

        buttonBottom = new MyButton(); // Create a new MyButton object
        buttonBottom.addActionListener(this); // Add an action listener to the button
        add(buttonBottom, constraints); // Add the button to the frame

        setVisible(true);
    }

    public static void main(String[] args) {
        new MyFrame("The Vanguard of Socialist Security");
    }

    @Override // Override the actionPerformed method from the ActionListener interface
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonTop) {
            buttonTop.toggleState();
        } else if (e.getSource() == buttonBottom) {
            buttonBottom.toggleState();
        }
    }
}


