package Laboration_1_A_small_button_component.src.Extra_Problem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Extra_Button extends JButton implements ActionListener {
    private boolean state;

    // Constructor to accept text and set the action command
    public Extra_Button(String text, String actionCommand) {
        super(text);
        setActionCommand(actionCommand);
        this.state = false;
        addActionListener(this); // Add the ActionListener to the button itself.
    }

    public void toggleState() {
        this.state = !this.state;
        // Implement your logic to change the button's appearance or behavior here.
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Handle the button click event here if needed.
        toggleState();
    }
}


