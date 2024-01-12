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
        initializeCircleBoundary(200/2, 200/2, 50); 
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

        // Iterate through all particles and draw them
        for (Particle particle : particleModel.getAllParticles()) {
            drawParticle(graphics, particle);
        }
        movementCounter++;
    }

    // Drawing the boundary of the simulation area
    private void drawBoundary(Graphics graphics) {
        // Drawing the circle
        int centerX = 200/2, centerY = 200/2, radius = 50; // Same as in initializeCircleBoundary
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
        int squareWidth = 200-4;
        graphics.drawLine(margin, margin, margin + squareWidth, margin); // Top edge
        graphics.drawLine(margin + squareWidth, margin, margin + squareWidth, margin + squareWidth); // Right edge
        graphics.drawLine(margin + squareWidth, margin + squareWidth, margin, margin + squareWidth); // Bottom edge
        graphics.drawLine(margin, margin + squareWidth, margin, margin); // Left edge
    }
    
    // Drawing a particle on the canvas 
    // The particle is drawn as a single pixel
    // This blurs the line between View and Controller => VC - M
    private void drawParticle(Graphics graphics, Particle particle) {
        int xPosition = (int) Math.round(particle.getXPosition());
        int yPosition = (int) Math.round(particle.getYPosition());
    
        // Check if the particle is within the boundary
        // If not, set the particle position to the boundary
        if (xPosition < 3) {
            xPosition = 2;
        } else if (xPosition > 200-3) {
            xPosition = 200-3;
        }
        if (yPosition < 3) {
            yPosition = 2;
        } else if (yPosition > 200-3) {
            yPosition = 200-3;
        }
    
        if (particle.isMovable()) {
            String positionKey = xPosition + "," + yPosition; // This is my key string

            // Should change color but its still movable since its not a boundary
            // The position is already occupied by another particle -> immovable
            if (boundaryMap.containsKey(positionKey) && boundaryMap.get(positionKey) == -1) {
                graphics.setColor(Color.RED); 
            } 
            // Encountered a boundary -> immovable
            else if (boundaryMap.containsKey(positionKey) && boundaryMap.get(positionKey) == 1) {
                graphics.setColor(Color.RED); 
                boundaryMap.put(positionKey, -1);
                particle.setMovable(false);
                updateBoundaryMapAround(xPosition, yPosition);
            } 
            // No boundary => movable
            else {
                graphics.setColor(Color.WHITE);
            }
        } 
        // Already immovable
        else {
            graphics.setColor(Color.RED);
        }
    
        graphics.drawLine(xPosition, yPosition, xPosition, yPosition);
    }
    
    
    // Mark the area around a particular particle as a boundary
    // Update the boundary map around the particle
    // 3x3 grid -> 8 points around the particle
    // Preventing Overlap -> If a point is already a boundary, don't update it
    // Dynamic Boundary Management -> If a point is already a boundary, don't update it
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
    
    //Here is the main method!
    public static void main(String[] args) {
        // 1. Create the model
        ParticleModel model = new ParticleModel();
        // 2. Create the view and send the model to its constructor
        SimulationView view = new SimulationView(model);
        // 3. Create the controller and send the model and view to its constructor
        ParticleSimulation simulation = new ParticleSimulation(model, view);
        // 4. Also create the control panel and send the model to its constructor
        ControlPanel controlPanel = new ControlPanel(model);

        // The rest of the code is just for setting up the GUI
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