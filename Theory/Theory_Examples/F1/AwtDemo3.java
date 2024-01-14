import java.awt.*;
import java.awt.event.*;
class AwtDemo3 extends Frame implements ActionListener {
  Button b = new Button("PLEASE PRESS");
  AwtDemo3 ( ) {
    setSize (300 ,300);
    setVisible (true );
    setBackground ( Color.cyan );
    add(b);
    b.addActionListener(this);
  }

  public void actionPerformed(ActionEvent e) {
    b.setBackground(Color.blue);
  }

  public static void main (String[] u) {
    AwtDemo3 window = new AwtDemo3();
  }
}
