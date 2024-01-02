import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ControlPanel extends JPanel implements AdjustmentListener {

    private JScrollBar redSlider, greenSlider, blueSlider;
    private ColorAndView colview;

    public ControlPanel (ColorAndView c) {
	setPreferredSize(new Dimension(100,150));
	colview = c;
	setBackground(Color.white);

	redSlider = setupSlider(Color.red);
	greenSlider = setupSlider(Color.green);
	blueSlider = setupSlider(Color.blue);
    }

    JScrollBar setupSlider(Color col) {
	JScrollBar slider = 
	    new JScrollBar(JScrollBar.VERTICAL, 0, 10, 0, 265);
	slider.setPreferredSize(new Dimension(20, 140));
	slider.setBackground(col);
	slider.addAdjustmentListener(this);
	add(slider);
	return slider;
    }

    public void adjustmentValueChanged(AdjustmentEvent e) {
	int redv = redSlider.getValue();
	int greenv =  greenSlider.getValue();
	int bluev = blueSlider.getValue();
	colview.setColor(redv, greenv, bluev);
	colview.repaint();
    }
}

