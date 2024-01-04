import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class SimulationView extends Canvas {
    ParticleModel particleModel;
    HashMap<String, Integer> boundaryMap = new HashMap<>();
    static int movementCounter;

    SimulationView(ParticleModel model) {
        particleModel = model;
        int width = 200, height = 200;
        setSize(width, height);

        // Initializing boundary coordinates
        for (int i = 0; i < 50; i++) {
            String topEdge = String.valueOf(75 + i) + "," + 75;
            String rightEdge = String.valueOf(125) + "," + (75 + i);
            String bottomEdge = String.valueOf(125 - i) + "," + 125;
            String leftEdge = String.valueOf(75) + "," + (125 - i);

            boundaryMap.put(topEdge, 1);
            boundaryMap.put(rightEdge, 1);
            boundaryMap.put(bottomEdge, 1);
            boundaryMap.put(leftEdge, 1);
        }
    }

    // Drawing the particles on the canvas
    @Override
    public void paint(Graphics graphics) {
        this.setBackground(Color.BLUE);
        graphics.setColor(Color.BLACK);
        drawBoundary(graphics);

        for (Particle particle : particleModel.getAllParticles()) {
            drawParticle(graphics, particle);
        }
        movementCounter++;
    }

    // Drawing the boundary of the simulation area
    private void drawBoundary(Graphics graphics) {
        graphics.drawLine(75, 75, 125, 75);
        graphics.drawLine(125, 75, 125, 125);
        graphics.drawLine(125, 125, 75, 125);
        graphics.drawLine(75, 125, 75, 75);

        graphics.drawLine(1, 1, 1, 199);
        graphics.drawLine(1, 199, 199, 199);
        graphics.drawLine(199, 199, 199, 1);
        graphics.drawLine(199, 1, 1, 1);
    }

    // Drawing the particle as a point on the canvas
    private void drawParticle(Graphics graphics, Particle particle) {
        int xPosition = (int) Math.round(particle.getXPosition());
        int yPosition = (int) Math.round(particle.getYPosition());
    
        // Ensuring the particle stays within bounds
        if (xPosition < 3) {
            xPosition = 2;
        } else if (xPosition > 197) {
            xPosition = 198;
        }
        if (yPosition < 3) {
            yPosition = 2;
        } else if (yPosition > 197) {
            yPosition = 198;
        }
    
        // Drawing the particle based on its movability
        if (particle.isMovable()) {
            String positionKey = xPosition + "," + yPosition;
            if (boundaryMap.containsKey(positionKey) && boundaryMap.get(positionKey) == -1) {
                graphics.setColor(Color.RED);
            } else if (boundaryMap.containsKey(positionKey) && boundaryMap.get(positionKey) == 1) {
                graphics.setColor(Color.RED);
                boundaryMap.put(positionKey, -1);
                particle.setMovable(false);
                updateBoundaryMapAround(xPosition, yPosition);
            } else {
                graphics.setColor(Color.WHITE);
            }
        } else {
            graphics.setColor(Color.RED);
        }
    
        // Drawing the particle as a point
        graphics.drawLine(xPosition, yPosition, xPosition, yPosition);
    }
    
    // Updating the boundary map around the particle that has stopped moving
    // to ensure that no other particle can move into the same position
    private void updateBoundaryMapAround(int x, int y) {
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                String key = (x + i) + "," + (y + j);
                if (!boundaryMap.containsKey(key)) {
                    boundaryMap.put(key, 1);
                }
            }
        }
    }
    
    // Updating the boundary map around the particle that has started moving
    // to ensure that no other particle can move into the same position
    public static void main(String[] args) {
        ParticleModel model = new ParticleModel();
        SimulationView view = new SimulationView(model);
        ParticleSimulation simulation = new ParticleSimulation(model, view);
        ControlPanel controlPanel = new ControlPanel(model);
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        panel.setSize(200, 200);
        panel.add(view);
        frame.add(panel, BorderLayout.CENTER);
        frame.add(controlPanel, BorderLayout.SOUTH);
        frame.setSize(400, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}