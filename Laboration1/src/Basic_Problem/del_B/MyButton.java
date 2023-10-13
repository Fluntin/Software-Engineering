package Basic_Problem.del_B;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

// This code is the same as in del_A
// The only difference is that the MyButton class implements ActionListener
public class MyButton extends JButton implements ActionListener {
    private int state;
    private final Color inactiveColor;
    private final Color activeColor;
    private final String inactiveText;
    private final String activeText;

    public MyButton() {
        this.inactiveColor = Color.GREEN;
        this.activeColor = Color.RED;
        this.inactiveText = "On";
        this.activeText = "Off";
        this.state = 0;

        setSize(100, 50);
        setBorderPainted(true);
        setOpaque(true);

        setBackground(inactiveColor);
        setText(inactiveText);

        addActionListener(this);
    }

    public void toggleState() {
        if (state == 0) {
            setBackground(activeColor);
            setText(activeText);
            state = 1;
        } else if (state == 1) {
            setBackground(inactiveColor);
            setText(inactiveText);
            state = 0;
        }
    }
    //The first setting is not required, but it is good practice to set the source of the event to the button itself.
    @Override // Override the actionPerformed method from the ActionListener interface
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this) {
            toggleState();
        }
    }
}




