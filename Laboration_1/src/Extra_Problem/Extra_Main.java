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
            return; // Return to exit the program.
        } catch (IndexOutOfBoundsException e) {
            System.out.println("No buttons added");
            System.exit(0);
            return; // Return to exit the program.
        }

        if ((args.length - 1) != n * 2) {
            System.out.println("Incorrect input: Incorrect number of strings");
            System.exit(0);
            return; // Return to exit the program.
        }

        SwingUtilities.invokeLater(() -> {
            Extra_Frame frame = new Extra_Frame();
            for (int i = 1; i < n * 2 + 1; i += 2) {
                Color color1 = getColorFromString(args[i]);
                Color color2 = getColorFromString(args[i + 1]);
                // You can modify the text as needed or use command-line arguments for it.
                MybuttonB button = new MybuttonB(color1, color2, "State 1", "State 2");
                frame.addButton(button);
            }
            
            frame.setVisible(true);
        });
    }

    private static Color getColorFromString(String colorString) {
        try {
            Color color = Color.decode(colorString);
            System.out.println("Decoded color: " + color);
            return color;
        } catch (NumberFormatException e) {
            System.out.println("Invalid color code: " + colorString);
            // Default to black if the color code is invalid
            return Color.BLACK;
        }
    }
    
}





