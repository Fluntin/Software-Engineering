package Extra_Problem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

class ToggleButton extends JButton implements ActionListener {
    private final Color INITIAL_COLOR;
    private final Color TOGGLE_COLOR;
    private final String INITIAL_TEXT;
    private final String TOGGLE_TEXT;
    private boolean isToggled = true;
    private List<ToggleButton> relatedButtons;

    ToggleButton(Color initialColor, Color toggleColor, String initialText, String toggleText, List<ToggleButton> relatedButtons) {
        this.INITIAL_COLOR = initialColor;
        this.TOGGLE_COLOR = toggleColor;
        this.INITIAL_TEXT = initialText;
        this.TOGGLE_TEXT = toggleText;
        this.relatedButtons = relatedButtons;

        setBackground(INITIAL_COLOR);
        setText(INITIAL_TEXT);
        setOpaque(true);
        setContentAreaFilled(true);
        setBorderPainted(false);
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (ToggleButton button : relatedButtons) {
            if (button != this) {
                button.switchState();
            }
        }
    }

    public void switchState() {
        if (isToggled) {
            setBackground(TOGGLE_COLOR);
            setText(TOGGLE_TEXT);
            isToggled = false;
        } else {
            setBackground(INITIAL_COLOR);
            setText(INITIAL_TEXT);
            isToggled = true;
        }
    }
}

