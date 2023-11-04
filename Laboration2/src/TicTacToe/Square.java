package TicTacToe;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

class Square extends JButton {

    private int rowIndex;
    private int colIndex;
    private String label;

    
    public Square(int i, int j, String label) {
        this.rowIndex = i;
        this.colIndex = j;
        this.label = label;

        // I did not write the estetic code below
        // However I wanted the game to look nice
        setText(label);
        setBackground(Color.BLUE);
        setForeground(Color.WHITE);
        setOpaque(true);
        setBorder(new LineBorder(Color.WHITE, 2)); // Set white border with a thickness of 2
        setFont(new Font("Arial", Font.BOLD, 20));
        setFocusPainted(false);
        setVisible(true);
    }

    // Add getter methods for rowIndex and colIndex
    public int getRowIndex() {
        return rowIndex;
    }

    public int getColIndex() {
        return colIndex;
    }
}


