import java.awt.*;
class AwtDemo2 extends Frame {
  Button b =new Button("PLEASE PRESS");
  AwtDemo2 ( ) {
    setSize (300 ,300);
    setVisible(true);
    setBackground(Color.cyan);
    add(b);
  }

  public static void main (String[] u) {
    AwtDemo2 window = new AwtDemo2();
  }
}
