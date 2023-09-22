import java.awt.*;
import java.awt.event.*;

class AwtDemo4 extends Frame implements ActionListener{
  Button b = new Button("PLEASE PRESS");
  Color [] colors ={Color.blue,Color.red,Color.green,
    Color.yellow };
  int colorindex = 0;
  AwtDemo4 ( ) {
    setVisible (true );
    setSize (300 ,300);
    setBackground(Color.cyan);
    add(b);
    b.addActionListener(this);
  }
  
  public void actionPerformed(ActionEvent e) {
      b. setBackground(colors[colorindex++%colors.length]);
  }
  public static void main (String[] u) {
    AwtDemo4 window = new AwtDemo4();
  }
}
