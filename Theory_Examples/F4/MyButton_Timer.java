import java.awt.*;
import java.awt.event.*; 
import javax.swing.*;

class MyButton extends JButton implements ActionListener{
    int i;

    MyButton(){
	super("Klicka här");
	i=0;
	setSize(50,50);
	addActionListener(this);

    }

    
    public void actionPerformed(ActionEvent ae){
	i+=1;
	setText(""+i);
	
    }


    public static void main(String[] args){

	JFrame f=new JFrame();
	f.setSize(50,50);
	MyButton mb=new MyButton();
	Timer t=new Timer(3000, mb);
	t.start();
	f.add(mb);
	f.setVisible(true);
    }
}


