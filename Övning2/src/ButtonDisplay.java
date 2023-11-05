import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.event.*;

// This class represents a JFrame with a custom component and a text field display.
class ButtonDisplay extends JFrame implements ActionListener {
    Component2 buttonsComponent; // Custom component with buttons
    JTextField displayField; // Text field for displaying button clicks

    // Constructor
    public ButtonDisplay() {
        setSize(300, 450);
        setLayout(new BorderLayout());
        
        buttonsComponent = new Component2();
        buttonsComponent.addActionListener(this);
        add(buttonsComponent, BorderLayout.CENTER);
        
        displayField = new JTextField();
        displayField.setEditable(false);
        add(displayField, BorderLayout.SOUTH);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    // Handle button clicks and update the display
    public void actionPerformed(ActionEvent ae) {
        displayField.setText(buttonsComponent.getContent());
    }

    // Main method to test the display
    public static void main(String[] args) {
        ButtonDisplay test = new ButtonDisplay();
    }
}
