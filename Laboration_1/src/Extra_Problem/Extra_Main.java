package Laboration_1.src.Extra_Problem;

import javax.swing.*;
import java.awt.*;

public class Extra_Main {
    public static void main(String[] args) {
        int n;
        try {
            n = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.out.println("Incorrect input: Integer required. Try again");
            System.exit(0);
            return;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("No buttons added");
            System.exit(0);
            return;
        }

        if ((args.length - 1) != n * 2) {
            System.out.println("Incorrect input: Incorrect number of strings");
            System.exit(0);
            return;
        }

        SwingUtilities.invokeLater(() -> {
            Extra_Frame frame = new Extra_Frame();
            for (int i = 1; i < n * 2 + 1; i += 2) {
                Color color1 = getColorFromString(args[i]);
                Color color2 = getColorFromString(args[i + 1]);
                Extra_Button button = new Extra_Button(color1, color2, "State 1", "State 2");
                frame.addButton(button);
            }
            frame.setVisible(true);
        });
    }

    private static Color getColorFromString(String colorString) {
        try {
            return Color.decode(colorString);
        } catch (NumberFormatException e) {
            System.out.println("Invalid color code: " + colorString);
            return Color.BLACK;
        }
    }
}





