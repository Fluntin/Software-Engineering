package Laboration_1.src.Extra_Problem;

import javax.swing.*;
import java.awt.*;

public class Extra_Frame extends JFrame {
    Extra_Frame() {
        setTitle("UML B");
        setSize(300, 300);
        getContentPane().setBackground(Color.blue);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
    }

    public void addButton(Extra_Button button) {
        add(button);
        revalidate();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Extra_Frame frame = new Extra_Frame();
            frame.setVisible(true);
        });
    }
}




