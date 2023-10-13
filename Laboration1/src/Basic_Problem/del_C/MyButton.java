package Basic_Problem.del_C;

import javax.swing.JButton;
import java.awt.Color;

// This code is the same as in del_B
// The only difference is that the MyButton class does not implement ActionListener
public class MyButton extends JButton {
    private int state;
    private Color inactiveColor;
    private Color activeColor;
    private final String INACTIVE_TEXT = "On";
    private final String ACTIVE_TEXT = "Off";
    private Ear ear;  // This allows the two-way relationship

    public MyButton() {
        inactiveColor = Color.GREEN;
        activeColor = Color.RED;
        state = 0;

        setSize(50, 50);
        setVisible(true);
        setBorderPainted(true);
        setOpaque(true);

        setBackground(inactiveColor);
        setText(INACTIVE_TEXT);

        ear = new Ear(this);  // Setting up the relationship
        addActionListener(ear);
    }

    public void toggleState() {
        if (state == 0) {
            setBackground(activeColor);
            setText(ACTIVE_TEXT);
            state = 1;
        } else if (state == 1) {
            setBackground(inactiveColor);
            setText(INACTIVE_TEXT);
            state = 0;
        }
    }
}



