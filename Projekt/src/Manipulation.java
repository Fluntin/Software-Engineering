import javax.swing.*;
import java.awt.*;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

public class Manipulation extends JPanel {
    Model model;

    Manipulation(Model model) {
        this.model = model;

        JTextField timeText = new JTextField("Change in time");
        JTextField lengthText = new JTextField("Change in vector length");

        timeText.setEditable(false);
        lengthText.setEditable(false);

        JScrollBar timeScrollBar = new JScrollBar(Scrollbar.VERTICAL, model.getTime(), 1, 0, 1000);
        JScrollBar lengthScrollBar = new JScrollBar(Scrollbar.VERTICAL, model.getLength(), 1, 0, 20);

        timeScrollBar.setPreferredSize(new Dimension(20, 100));
        lengthScrollBar.setPreferredSize(new Dimension(20, 100));

        timeScrollBar.addAdjustmentListener(e -> {
            int time = e.getValue();
            model.setTime(time);
        });

        lengthScrollBar.addAdjustmentListener(e -> {
            int length = e.getValue();
            model.setLength(length);
        });

        add(timeText, BorderLayout.WEST);
        add(timeScrollBar);
        add(lengthScrollBar);
        add(lengthText, BorderLayout.EAST);

        setSize(200, 200);
    }
}


