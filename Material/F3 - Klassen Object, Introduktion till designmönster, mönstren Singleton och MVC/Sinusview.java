import java.awt.*;
import javax.swing.*;
class Sinusview extends JPanel {

    Sinusmodel mod;
    int yOff = 200;

    Sinusview (Sinusmodel sm) {
	mod = sm;
	setPreferredSize(new Dimension(500,400));
	setBackground(Color.cyan);
    }

    public void paintComponent(Graphics g) {
	super.paintComponent(g);
	g.setFont(new Font("Roman", Font.PLAIN, 20));
	//	g.setFont(new Font("Roman", Font.BOLD, 20));

	g.drawString
 	    ((int)(mod.a) + "sin(2\u03C0x/" + (int)(mod.p) +  
 	     " +  " + mod.alfa + ")", 150, 40);
	// \u03C0x is hexadecimal Unicode for character pi
 
	int x1 = 0; int y1 = yOff + (int)(Math.round(mod.sin(0)));
	int x2, y2, dx = 3;
	while (x1 < getWidth()) {
	    x2 = x1 + dx;
	    y2 = yOff + (int)(Math.round(mod.sin(x2)));
	    g.drawLine(x1, y1, x2, y2);
	    x1 = x2; y1 = y2;
	}
    }
}

