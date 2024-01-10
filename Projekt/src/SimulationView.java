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
        initializeCircleBoundary(100, 100, 50);
        initializeSquareBoundary(width, height);
    }

    // Initializing the circle boundary of the simulation area
    private void initializeCircleBoundary(int centerX, int centerY, int radius) {
        for (int angle = 0; angle < 360; angle++) {
            double rad = Math.toRadians(angle);
            int x = centerX + (int)(radius * Math.cos(rad));
            int y = centerY + (int)(radius * Math.sin(rad));
            String key = x + "," + y;
            boundaryMap.put(key, 1);
        }
    }

    private void initializeSquareBoundary(int width, int height) {
        int margin = 2; // Margin from the edge
        int squareWidth = width - 2 * margin; // Width of the square, 196 pixels
    
        // Top and Bottom edges
        for (int x = margin; x < margin + squareWidth; x++) {
            String topEdge = x + "," + margin;
            String bottomEdge = x + "," + (margin + squareWidth - 1);
            boundaryMap.put(topEdge, 1);
            boundaryMap.put(bottomEdge, 1);
        }
    
        // Left and Right edges
        for (int y = margin; y < margin + squareWidth; y++) {
            String leftEdge = margin + "," + y;
            String rightEdge = (margin + squareWidth - 1) + "," + y;
            boundaryMap.put(leftEdge, 1);
            boundaryMap.put(rightEdge, 1);
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
        // Drawing the circle
        int centerX = 100, centerY = 100, radius = 50; // Same as in initializeCircleBoundary
        for (int angle = 0; angle < 360; angle++) {
            double rad = Math.toRadians(angle);
            int x1 = centerX + (int)(radius * Math.cos(rad));
            int y1 = centerY + (int)(radius * Math.sin(rad));
            rad = Math.toRadians(angle + 1); // Slightly increment angle for next point
            int x2 = centerX + (int)(radius * Math.cos(rad));
            int y2 = centerY + (int)(radius * Math.sin(rad));
            graphics.drawLine(x1, y1, x2, y2); // Draw line between two adjacent points
        }
    
        // Drawing the square
        int margin = 2; // Same as in initializeSquareBoundary
        int squareWidth = 196; // Width of the square
        graphics.drawLine(margin, margin, margin + squareWidth, margin); // Top edge
        graphics.drawLine(margin + squareWidth, margin, margin + squareWidth, margin + squareWidth); // Right edge
        graphics.drawLine(margin + squareWidth, margin + squareWidth, margin, margin + squareWidth); // Bottom edge
        graphics.drawLine(margin, margin + squareWidth, margin, margin); // Left edge
    }
    

    // Drawing the particle as a point on the canvas
    private void drawParticle(Graphics graphics, Particle particle) {
        int xPosition = (int) Math.round(particle.getXPosition());
        int yPosition = (int) Math.round(particle.getYPosition());
    
        // Ensuring the particle stays within bounds
        if (xPosition < 3) {
            xPosition = 2;
        } else if (xPosition > 197) {
            xPosition = 197;
        }
        if (yPosition < 3) {
            yPosition = 2;
        } else if (yPosition > 197) {
            yPosition = 197;
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
        frame.setSize(800, 600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}