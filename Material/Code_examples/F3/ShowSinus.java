import javax.swing.*;
import java.awt.*;
class ShowSinus extends JFrame {

    ShowSinus () {
	setSize(700, 400);
	setLayout(new FlowLayout());
	getContentPane().setBackground(Color.white);
	Sinusmodel model = new Sinusmodel();
	Sinusview view = new Sinusview(model);
	Sinuscontrol control = new Sinuscontrol(model, view);
	add(view,BorderLayout.CENTER);
	add(control,BorderLayout.EAST);
	setVisible(true);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main (String[] x) {
	new ShowSinus();
    }
}
