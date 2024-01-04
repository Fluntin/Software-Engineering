import javax.swing.*;
import java.awt.*;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

public class ControlPanel extends JPanel {
    ParticleModel particleModel;

    ControlPanel(ParticleModel particleModel) {
        this.particleModel = particleModel;

        JTextField timeTextField = new JTextField("Change in time");
        JTextField lengthTextField = new JTextField("Change in vector length");

        timeTextField.setEditable(false);
        lengthTextField.setEditable(false);

        JScrollBar timeScrollBar = new JScrollBar(Scrollbar.VERTICAL, particleModel.getSimulationTime(), 1, 0, 1000);
        JScrollBar lengthScrollBar = new JScrollBar(Scrollbar.VERTICAL, particleModel.getVectorLength(), 1, 0, 20);

        timeScrollBar.setPreferredSize(new Dimension(20, 100));
        lengthScrollBar.setPreferredSize(new Dimension(20, 100));

        timeScrollBar.addAdjustmentListener(new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                int timeValue = e.getValue();
                particleModel.setSimulationTime(timeValue);
            }
        });

        lengthScrollBar.addAdjustmentListener(new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                int lengthValue = e.getValue();
                particleModel.setVectorLength(lengthValue);
            }
        });

        add(timeTextField, BorderLayout.WEST);
        add(timeScrollBar);
        add(lengthScrollBar);
        add(lengthTextField, BorderLayout.EAST);

        setSize(200, 200);
    }
}