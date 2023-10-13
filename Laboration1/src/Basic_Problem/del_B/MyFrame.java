package Basic_Problem.del_B;


import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

// This code is the same as in del_A
// The only difference is that the MyFrame class does not implement ActionListener
public class MyFrame extends JFrame {
    public MyFrame(String title) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(500, 500);
        setTitle(title);

        // Create a panel to hold the buttons with a GridLayout
        JPanel buttonPanel = new JPanel(new GridLayout(1, 3, 10, 0));

        // Create three buttons
        MyButton Button1 = new MyButton();
        MyButton Button2 = new MyButton();
        MyButton Button3 = new MyButton();

        // Add the buttons to the panel
        buttonPanel.add(Button1);
        buttonPanel.add(Button2);
        buttonPanel.add(Button3);

        // Add the panel to the center of the frame
        add(buttonPanel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        new MyFrame("Trinity");
    }
}
