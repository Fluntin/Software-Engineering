package Basic_Problem.del_C;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

// This code is the same as in del_B
// The only difference is that the Ear class implements ActionListener
// and the MyButton class does not implement ActionListener
public class Ear implements ActionListener {
    private MyButton button;

    public Ear(MyButton button) {
        this.button = button;
    }
    // Its a good practice to get this button from the event source
    @Override
    public void actionPerformed(ActionEvent e) {
        this.button.toggleState();
    }
}


