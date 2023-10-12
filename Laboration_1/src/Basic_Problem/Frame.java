// Frame.java

package Laboration_1.src.Basic_Problem;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    
    private JPanel panel;

    public Frame() {
        // JFrame Initialization
        setTitle("Erik & Villim");
        setSize(640, 360);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // JPanel Initialization
        panel = new JPanel();
        panel.setBackground(Color.darkGray);

        JButton button1 = new Button(Color.lightGray, Color.darkGray, "On", "Off");
        JButton button2 = new Button(Color.darkGray, Color.lightGray, "Run", "Stop");
        panel.add(button1);
        panel.add(button2);

        // Adding Panel to the Frame
        add(panel);

        // Setting frame visible after adding components
        setVisible(true);
    }

    public void addButton(JButton button) {
        panel.add(button);
        panel.revalidate();
        panel.repaint();
    }
}