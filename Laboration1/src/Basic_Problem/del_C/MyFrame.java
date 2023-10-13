package Basic_Problem.del_C;

import javax.swing.JFrame;
import java.awt.GridLayout;

// This code is the same as in del_B
// The only difference is that the MyFrame class does not implement ActionListener
public class MyFrame extends JFrame {

    public MyFrame(String title) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 1)); 
        setSize(500, 500);
        setTitle(title);
        setVisible(true);

        MyButton buttonTop = new MyButton();
        MyButton buttonBottom = new MyButton();

        add(buttonTop);
        add(buttonBottom);
    }

    public static void main(String[] args) {
        new MyFrame("Just a Frame the Ear Frame");
    }
}
