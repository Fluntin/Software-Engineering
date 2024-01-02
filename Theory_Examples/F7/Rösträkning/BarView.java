import java.awt.*;
import javax.swing.*;
import java.util.*;
class BarView extends JFrame implements Observer {

    VotesModel mod;
    Barpanel panel;

    BarView () {
	super("Bar view of chocolate voting");
	setSize(300,300);
	panel = new Barpanel();
	add(panel);
	setVisible(true);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    // According to interface Observer
    public void update(Observable obs, Object arg) {
	this.mod = (VotesModel) obs;
	panel.repaint(); // update panel using mod, the Observable
    }


    class Barpanel extends JPanel {
	Barpanel () {
	    setBackground(Color.white);
	}

	public void paintComponent(Graphics g) {
	    if (mod == null)
		return;
	    super.paintComponent(g);

	    int w = getWidth();
	    int h = getHeight();
	    int bigmax = 25;
	    int max= 0;
	    for (int i=0; i<mod.getN(); i++){
		int t = mod.getFreq(i);
		if (t > max)
		    max = t;
	    }
	    if (max == 0) { // nothing to draw
		return;
	    }
	    while (max > bigmax)  // bars will fit in the image
		bigmax *=2;
	    
	    int maxbarh = (int)(0.8*h);
	    int ybottom = (int)(0.9*h);
	    int dw = (int)(0.8*w/6);
	    int x = (int)(0.1*w);
	    for (int i=0; i<mod.getN(); i++) {
		if (mod.getFreq(i) > 0) {
		    g.setColor(mod.getCol(i));
		    int currh = 
			(int)Math.round(1.0*maxbarh*mod.getFreq(i)/bigmax);
		    g.fillRect(x,ybottom-currh,dw,currh);
		}
		x += dw;
	    }
	    
	}
    }
}
