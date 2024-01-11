import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentListener;
//--------------------------------------------------------------------------------------------
//Serves as a user interface component for a particle simulation application. 
//It allows users to interact with and control the simulation through various GUI elements
//--------------------------------------------------------------------------------------------

public class ControlPanel extends JPanel {
    private ParticleModel particleModel;

    //--------------------------------------------------------------------------------------------
    // Constructor ->  Accepts an instance of ParticleModel thats managing the particle simulation logic
    //--------------------------------------------------------------------------------------------
    ControlPanel(ParticleModel particleModel) {
        this.particleModel = particleModel;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); //Set layout of the panel to BoxLayout
        initializeComponents(); 
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    }

    // Method to initialize and set up components
    private void initializeComponents() {
        // Create and setup labels
        JLabel timeLabel = createLabel("Change in time");
        JLabel lengthLabel = createLabel("Change in vector length");

        // Create and setup scroll bars
        JScrollBar timeScrollBar = createScrollBar(particleModel.getSimulationTime(), 0, 1000);
        JScrollBar lengthScrollBar = createScrollBar(particleModel.getVectorLength(), 0, 20);

        // Add adjustment listeners to scroll bars
        timeScrollBar.addAdjustmentListener(createAdjustmentListenerForTime());
        lengthScrollBar.addAdjustmentListener(createAdjustmentListenerForLength());

        // Create and setup buttons
        //JButton resetButton = createButton("Reset Simulation", this::resetSimulation);
        JButton closeButton = createButton("Close Program", this::closeProgram);

        // Add components to panel
        addComponent(timeLabel);
        addComponent(timeScrollBar);
        addComponent(lengthLabel);
        addComponent(lengthScrollBar);
        //addComponent(resetButton);
        addComponent(closeButton);
    }

    // Helper method to create and style a label
    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        label.setFont(new Font("Arial", Font.BOLD, 12));
        label.setForeground(new Color(50, 50, 50));
        return label;
    }

    // Helper method to create and style a scroll bar
    private JScrollBar createScrollBar(int value, int min, int max) {
        JScrollBar scrollBar = new JScrollBar(Scrollbar.HORIZONTAL, value, 1, min, max);
        scrollBar.setMaximumSize(new Dimension(180, 20));
        return scrollBar;
    }

    // Helper method to create and style a button
    private JButton createButton(String text, ActionListener actionListener) {
        JButton button = new JButton(text);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.addActionListener(actionListener);
        return button;
    }

    // Helper method to create an adjustment listener for time
    private AdjustmentListener createAdjustmentListenerForTime() {
        return e -> particleModel.setSimulationTime(e.getValue());
    }

    // Helper method to create an adjustment listener for length
    private AdjustmentListener createAdjustmentListenerForLength() {
        return e -> particleModel.setVectorLength(e.getValue());
    }

    // Method to close the program
    private void closeProgram(ActionEvent e) {
        System.exit(0);
    }

    // Helper method to add and align components in the panel
    private void addComponent(JComponent component) {
        add(Box.createRigidArea(new Dimension(0, 5))); // Add spacing
        add(component);
    }
}