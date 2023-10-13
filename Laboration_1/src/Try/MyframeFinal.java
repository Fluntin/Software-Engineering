package Laboration_1.src.Try;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class MyFrameFinal extends JFrame {
    private List<MyButtonFinal> buttons = new ArrayList<>();

    MyFrameFinal(String[] args) {
        setTitle("Extra");
        setSize(300, 300);
        getContentPane().setBackground(Color.blue);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        if (args.length < 3 || args.length % 2 == 0) {
            System.err.println("Invalid arguments provided.");
            return;
        }

        int numButtons;
        try {
            numButtons = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.err.println("First argument should be an integer.");
            return;
        }

        for (int i = 0; i < numButtons; i++) {
            MyButtonFinal button = new MyButtonFinal(Color.green, Color.red, args[2 * i + 1], args[2 * i + 2], buttons);
            buttons.add(button);
            add(button);
        }

        setVisible(true);
    }

    public static void main(String[] args) {
        new MyFrameFinal(args);
    }
}

class MyButtonFinal extends JButton implements ActionListener {
    private final Color COLOR1;
    private final Color COLOR2;
    private final String TEXT1;
    private final String TEXT2;
    private boolean isText2State = true;
    private List<MyButtonFinal> allButtons;

    MyButtonFinal(Color color1, Color color2, String text1, String text2, List<MyButtonFinal> allButtons) {
        this.COLOR1 = color1;
        this.COLOR2 = color2;
        this.TEXT1 = text1;
        this.TEXT2 = text2;
        this.allButtons = allButtons;

        setBackground(COLOR1);
        setText(TEXT1);
        setOpaque(true);
        setContentAreaFilled(true);
        setBorderPainted(false);
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (MyButtonFinal button : allButtons) {
            if (button != this) {
                button.toggleState();
            }
        }
    }

    public void toggleState() {
        if (isText2State) {
            setBackground(COLOR2);
            setText(TEXT2);
            isText2State = false;
        } else {
            setBackground(COLOR1);
            setText(TEXT1);
            isText2State = true;
        }
    }
}