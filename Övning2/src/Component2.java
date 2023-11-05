import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.*;
import java.awt.GridLayout;
import java.util.ArrayList;

// This class represents a custom component with buttons.
class Component2 extends JPanel implements ActionListener {
    JButton[] buttons; // Array to hold buttons
    public static final String buttonText = "123456789*0#"; // Text for buttons
    StringBuilder buffer; // Text buffer to store button clicks
    ArrayList<ActionListener> listeners; // Listeners for button actions

    // Constructor
    public Component2() {
        buttons = new JButton[12]; // Create an array of buttons
        setSize(300, 400);
        setLayout(new GridLayout(4, 3));
        
        // Initialize buttons and add them to the panel
        for (int i = 0; i < buttonText.length(); i++) {
            buttons[i] = new JButton(buttonText.substring(i, i + 1));
            add(buttons[i]);
            buttons[i].addActionListener(this);
        }
        
        buffer = new StringBuilder(); // Initialize the text buffer
        listeners = new ArrayList<ActionListener>(); // Initialize the listeners list
    }

    // Add an action listener
    public void addActionListener(ActionListener al) {
        listeners.add(al);
    }

    // Get the current content of the text buffer
    public String getContent() {
        return buffer.toString();
    }

    // Handle button clicks
    public void actionPerformed(ActionEvent ae) {
        String actionCommand = ae.getActionCommand();
        
        // Clear the buffer when the '*' button is clicked
        if (actionCommand.equals("*")) {
            buffer = new StringBuilder();
        } 
        // Delete the last character when the '#' button is clicked
        else if (actionCommand.equals("#")) {
            if (buffer.length() > 0) {
                buffer.deleteCharAt(buffer.length() - 1);
            }
        } 
        // Append the button's text to the buffer
        else {
            buffer.append(actionCommand);
        }
        
        // Notify all registered action listeners
        for (ActionListener listener : listeners) {
            listener.actionPerformed(ae);
        }
    }

    // Main method to test the component
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(300, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Component2 component = new Component2();
        frame.add(component);
        frame.setVisible(true);
    }
}

