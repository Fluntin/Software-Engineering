package Laboration_1_A_small_button_component.src.Basic_Problem;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Frame frame = new Frame();
        frame.addButton(new Button(Color.lightGray, Color.darkGray, "On", "Off"));
    }

    }