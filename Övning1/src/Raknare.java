import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

class Raknare extends JFrame implements ActionListener {
    Display disp;
    Knappsats knappar;
    String visas = "0";
    double dispVarde, minne;
    char operator = 0;

    private Raknare() {
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        disp = new Display();
        knappar = new Knappsats(this);
        setLayout(new BorderLayout());
        add(disp, BorderLayout.NORTH);
        add(knappar, BorderLayout.CENTER);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Raknare huvudFonster = new Raknare();
        });
    }

    public void actionPerformed(ActionEvent ae) {
        String knapp = ae.getActionCommand();
        char tkn = knapp.charAt(0);

        if (Character.isDigit(tkn)) {
            handleDigitInput(tkn);
        } else if (tkn == '+') {
            handleOperator('+');
        }
    }

    private void handleDigitInput(char digit) {
        int num = Character.getNumericValue(digit);

        if (!visas.equals("0")) {
            visas += digit;
        } else {
            visas = String.valueOf(num);
        }
        disp.setText(visas);
    }

    private void handleOperator(char op) {
        if (minne == 0) {
            minne = Double.parseDouble(visas);
            operator = op;
            visas = "0";
        } else {
            minne += Double.parseDouble(visas);
            operator = op;
            disp.setText(String.valueOf(minne));
            visas = "0";
        }
    }
}
