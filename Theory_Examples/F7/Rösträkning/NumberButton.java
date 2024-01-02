import java.awt.*;
import javax.swing.*;
class NumberButton extends JButton {
    
    int number = 0;
    NumberButton(String s, int num) {
	super(s);
	number = num;
    }

}