// Button.java

package Laboration_1.src.Basic_Problem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Button extends JButton implements ActionListener {
    private Color c1;
    private Color c2;
    private String s1;
    private String s2;

    Button(Color c1, Color c2, String s1, String s2) {
        this.c1 = c1;
        this.c2 = c2;
        this.s1 = s1;
        this.s2 = s2;

        this.setBackground(c1);
        this.setText(s1);
        this.setForeground(Color.white);
        this.addActionListener(this);
    }

    private void toggleState() {
        Color toggleColor = this.getBackground().equals(c1) ? c2 : c1;
        String toggleText = this.getText().equals(s1) ? s2 : s1;
        this.setBackground(toggleColor);
        this.setText(toggleText);
    }

    public void actionPerformed(ActionEvent a) {
        this.toggleState();
    }
}
