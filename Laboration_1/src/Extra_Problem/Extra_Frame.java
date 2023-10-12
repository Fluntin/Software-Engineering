package Laboration_1.src.Extra_Problem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Extra_Frame extends JFrame {
    Extra_Frame() {
        setTitle("UML B");
        setSize(300, 300);
        getContentPane().setBackground(Color.blue);  // Set background color of content pane
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
    }

    public void addButton(MybuttonB button) {
        add(button);
        revalidate(); // Refresh the layout
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Extra_Frame frame = new Extra_Frame();
            frame.setVisible(true);
        });
    }
}

class MybuttonB extends JButton {
    private final Color COLOR1;
    private final Color COLOR2;
    private final String TEXT1;
    private final String TEXT2;
    private boolean stateis2 = true;  // Initialized to true

    MybuttonB(Color color1, Color color2, String text1, String text2) {
        this.COLOR1 = color1;
        this.COLOR2 = color2;
        this.TEXT1 = text1;
        this.TEXT2 = text2;
        setBackground(COLOR1);
        setText(TEXT1);
        setOpaque(true);
        setContentAreaFilled(true);
        setBorderPainted(false);
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toggleState3();
            }
        });
    }

    public void toggleState3() {
        if (stateis2) {
            setBackground(COLOR2);
            setText(TEXT2);
            stateis2 = false;
        } else {
            setBackground(COLOR1);
            setText(TEXT1);
            stateis2 = true;
        }
    }
}




