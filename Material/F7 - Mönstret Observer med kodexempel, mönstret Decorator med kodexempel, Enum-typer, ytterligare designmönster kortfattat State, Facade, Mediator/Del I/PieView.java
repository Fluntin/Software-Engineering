import java.awt.*;
import javax.swing.*;
import java.util.*;
class PieView extends JFrame implements Observer {

    VotesModel mod;
    Piepanel panel;

    PieView () {
	super("Pie view of chocolate voting");
	setSize(300,300);
	panel = new Piepanel();
	add(panel);
	setVisible(true);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    // According to interface Observer
    public void update(Observable obs, Object arg) {
	this.mod = (VotesModel) obs;
	panel.repaint(); // update panel using mod, the Observable
    }

    class Piepanel extends JPanel {
	int radius = 80;

	Piepanel () {
	    setBackground(Color.white);
	}

	public void paintComponent(Graphics g) {
	    if (mod == null)
		return;
	    super.paintComponent(g);

	    int midx = getWidth()/2;
	    int midy = getHeight()/2;
	    int sum = 0;
	    for (int i=0; i<mod.getN(); i++)
		sum += mod.getFreq(i);
	    if (sum == 0) {
		g.drawOval(midx-radius,midy-radius,2*radius,2*radius);
		return;
	    }
	    int acksum=0;
	    int ackarc = 0;
	    int currarc=0;
	    for (int i=0; i< mod.getN(); i++) {
		if (mod.getFreq(i) > 0) {
		    currarc = (int) Math.round(360.0*mod.getFreq(i)/sum);
		    g.setColor(mod.getCol(i));
		    g.fillArc(midx-radius,midy-radius,2*radius,2*radius,
			      ackarc,currarc);
		    acksum += mod.getFreq(i);
		    ackarc = (int) Math.round(360.0*acksum/sum);
		}
	    }
	}
    }
}

