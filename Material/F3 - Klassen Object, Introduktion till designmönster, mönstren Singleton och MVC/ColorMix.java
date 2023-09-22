import java.awt.*;
import javax.swing.*;

public class ColorMix extends JFrame {

    public ColorMix () {
	setLayout(new FlowLayout());
	setSize(400, 300);
	JPanel p = new JPanel();
	p.setLayout(new GridLayout(2,1));
	JLabel l1 = 
	    new JLabel("Välkommen till färgblandaren!");
	JLabel l2 = 
	    new JLabel("Ställ in rött, grönt och blått!");
	p.add(l1);
	p.add(l2);
	add(p);

	ColorAndView cav = new ColorAndView();    // model and view
	ControlPanel cp = new ControlPanel(cav);  // control

	add(cav);
	add(cp);
	setVisible(true);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main (String[] x) {
	new ColorMix();
    }
}
