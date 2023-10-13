package Extra_Problem;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

// This is my main class for the Extra Problem.
public class ButtonFrame extends JFrame {
    private List<ToggleButton> toggleButtons = new ArrayList<>();

    //
    ButtonFrame(String[] args) {
        setTitle("Sisyphus's button-pushing adventures");
        setSize(680, 400);
        getContentPane().setBackground(new Color(240, 248, 255)); // Nice color scheme i found online.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Check if the number of arguments is valid
        if (args.length < 3 || args.length % 2 == 0) {
            System.err.println("Invalid arguments provided please note that its number of buttons then tex1 and text2 for each of the buttons.");
            return;
        }

        // Check if the first argument is an integer!
        int buttonCount;
        try {
            buttonCount = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.err.println("First argument should be an integer representing the number of butonns you want.");
            return;
        }

        for (int i = 0; i < buttonCount; i++) {
            ToggleButton button = new ToggleButton(new Color(255, 255, 238), new Color(229, 43, 80),args[2 * i + 1], args[2 * i + 2], toggleButtons);
            toggleButtons.add(button);
            add(button);
        }

        setVisible(true);
    }

    public static void main(String[] args) {
        new ButtonFrame(args);
    }
}

