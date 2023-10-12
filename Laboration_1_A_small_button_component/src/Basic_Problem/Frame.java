//Import Statements:

package Laboration_1_A_small_button_component.src.Basic_Problem;

import javax.swing.*;
import java.awt.*;

//Class Definition: Frame
class Frame extends JFrame {
    
    private JPanel panel;
    
    //Constructor:
    Frame() {

        //JFrame Initialization:

        //Here object of JFrame is created called frame!
        JFrame frame = new JFrame("Erik & Villim");
        frame.setVisible(true);
        frame.setSize(640,360);

        //This is to make sure that the program exits when the frame is closed.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //JPanel Initialization:
        panel = new JPanel();
        JButton button1 = new Laboration_1_A_small_button_component.src.Basic_Problem.Button(Color.lightGray, Color.darkGray, "On", "Off");
        JButton button2 = new Laboration_1_A_small_button_component.src.Basic_Problem.Button(Color.darkGray, Color.lightGray, "Run", "Stop");
        panel.setBackground(Color.darkGray);

        //Adding Panel to the Frame:
        frame.add(panel);
        panel.add(button1);
        panel.add(button2);

    }

    void addButton(JButton button) {
        panel.add(button);
    }
}