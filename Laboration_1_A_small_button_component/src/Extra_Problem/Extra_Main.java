package Laboration_1_A_small_button_component.src.Extra_Problem;

import javax.swing.*;

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
            for (int i = 1; i < n * 2; i += 2) {
                frame.addButton(new Extra_Button(args[i], args[i + 1]));
            }
            frame.setVisible(true);
        });
    }
}


