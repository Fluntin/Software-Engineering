package Laboration_1_A_small_button_component.src.Extra_Problem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Extra_Frame extends JFrame implements ActionListener {

    private JPanel panel;
    private ArrayList<Extra_Button> MyButtonArray;

    public Extra_Frame() {
        MyButtonArray = new ArrayList<>();
        setTitle("Erik & Villim"); // Set the title using setTitle method.
        setSize(600, 360);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setBackground(Color.darkGray);

        add(panel);
    }

    void addButton(Extra_Button button) {
        button.addActionListener(this); // "this" refers to the current instance of Extra_Frame, which now implements ActionListener.
        MyButtonArray.add(button);
        panel.add(button);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        int indexButton = MyButtonArray.indexOf(actionEvent.getSource());
        for (int i = 0; i < MyButtonArray.size(); i++) {
            if (i != indexButton) {
                MyButtonArray.get(i).toggleState();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Extra_Frame().setVisible(true);
        });
    }
}


