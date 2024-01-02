
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class Sinuscontrol extends JPanel implements ActionListener {
    
    Sinusmodel m;
    Sinusview v;
    JButton incrP = new JButton("Period +");
    JButton decrP = new JButton("Period -");
    JButton incrF = new JButton("Phase +");
    JButton decrF = new JButton("Phase -");
    JButton incrA = new JButton("Amplitude +");
    JButton decrA = new JButton("Amplitude -");

    
    Sinuscontrol (Sinusmodel sm, Sinusview sv) {
	m = sm;
	v = sv;
	setLayout(new GridLayout(6,1));
	add(incrP); add(decrP);
	add(incrF); add(decrF);
	add(incrA); add(decrA);
	incrP.addActionListener(this);
	decrP.addActionListener(this);
	incrF.addActionListener(this);
	decrF.addActionListener(this);
	incrA.addActionListener(this);
	decrA.addActionListener(this);
    }

    public void actionPerformed (ActionEvent e) {
	if (e.getSource() == incrP)
	    m.changePer(5);
	else if (e.getSource() == decrP)
	    m.changePer(-5);
	if (e.getSource() == incrF)
	    m.changePha(0.5);
	else if (e.getSource() == decrF)
	    m.changePha(-0.5);
	if (e.getSource() == incrA)
	    m.changeAmp(5);
	else if (e.getSource() == decrA)
	    m.changeAmp(-5);

	v.repaint();
    }
}
