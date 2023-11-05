import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Knappsats extends JPanel {
    public Knappsats(ActionListener master) {
        setSize(300, 300);
        setLayout(new GridLayout(5, 4));
        String ordning = "789+456-123*0,=/";
        for (int i = 0; i < ordning.length(); i++) {
            String knapptext = "" + ordning.charAt(i);
            Knapp temp = new Knapp();
            temp.setText(knapptext);
            temp.addActionListener(master);
            add(temp);
        }
    }
}
