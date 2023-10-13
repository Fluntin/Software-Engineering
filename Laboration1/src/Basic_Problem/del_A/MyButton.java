package Basic_Problem.del_A;

import java.awt.Color;
import javax.swing.JButton;


public class MyButton extends JButton {
    private int currentState;
    private final Color deactivatedColor = Color.GRAY;
    private final Color activatedColor = Color.ORANGE;
    private final String deactivatedLabel = "Авторизация Запуска";
    private final String activatedLabel = "Nuclear Launch Detected";

    // Constructor for MyButton
    public MyButton() {
        setSize(50, 50);
        setBorderPainted(true);
        setOpaque(true);

        setCurrentState(0);
    }
    // Getters and setters
    public void setCurrentState(int state){
        this.currentState = state;
        if (state == 0) {
            this.setBackground(deactivatedColor);
            this.setText(deactivatedLabel);
        } else {
            this.setBackground(activatedColor);
            this.setText(activatedLabel);
        }
    }
    // Getters and setters for currentState 
    public void toggleState(){
        setCurrentState(currentState == 0 ? 1 : 0);
    }
}