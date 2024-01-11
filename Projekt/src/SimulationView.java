import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

//--------------------------------------------------------------------------------------------
// Responsible for the visual representation of the particle simulation. 
// It is a canvas that displays the particles and their movement.
//--------------------------------------------------------------------------------------------
public class SimulationView extends Canvas {
    ParticleModel particleModel;
    HashMap<String, Integer> boundaryMap = new HashMap<>();
    static int movementCounter;

    //--------------------------------------------------------------------------------------------
    // Constructor -> Accepts an instance of ParticleModel 
    // thats managing the particle simulation logic
    //--------------------------------------------------------------------------------------------
    SimulationView(ParticleModel model) {
        particleModel = model; // Initialize the simulation area
        int width = 200, height = 200; // Width and height of the simulation area
        setSize(width, height); // Set the size of the canvas
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

    // Initializing the square boundary of the simulation area
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
    
        int margin = 2; 
        int squareWidth = 196;
        graphics.drawLine(margin, margin, margin + squareWidth, margin); // Top edge
        graphics.drawLine(margin + squareWidth, margin, margin + squareWidth, margin + squareWidth); // Right edge
        graphics.drawLine(margin + squareWidth, margin + squareWidth, margin, margin + squareWidth); // Bottom edge
        graphics.drawLine(margin, margin + squareWidth, margin, margin); // Left edge
    }
    
    // Drawing a particle on the canvas 
    // The particle is drawn as a single pixel
    private void drawParticle(Graphics graphics, Particle particle) {
        int xPosition = (int) Math.round(particle.getXPosition());
        int yPosition = (int) Math.round(particle.getYPosition());
    
        // Check if the particle is within the boundary
        // If not, set the particle position to the boundary
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
    
        // Check if the particle is movable 
        // If not, set the color to red
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
    
        graphics.drawLine(xPosition, yPosition, xPosition, yPosition);
    }
    
    // Updating the boundary map around the particle
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