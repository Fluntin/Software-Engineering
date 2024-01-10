import java.awt.*;
import java.util.Random;

// This class is responsible for the movement of the particles in the simulation
// and the simulation time of the program (how many times the particles move)
public class Particle {
    private double xPosition, yPosition, angle;
    private int movementLength = 3;
    private Color color;
    private boolean isMovable = true;

    Particle() {
        color = Color.RED;
        generateRandomAngle();
        Random random = new Random();
        xPosition = 250 * random.nextDouble();
        yPosition = 250 * random.nextDouble();
    }

    // Generates a random angle for the particle to move in (in radians) 
    // and sets the x and y coordinates of the particle
    private void generateRandomAngle() {
        Random random = new Random();
        angle = 2 * Math.PI * random.nextDouble();
    }

    // Moves the particle in a random direction based on the angle generated 
    public void moveRandomly() {
        generateRandomAngle();
        xPosition += movementLength * Math.cos(angle);
        yPosition += movementLength * Math.sin(angle);
    }

    // Gets the coordinates of the particle 
    public double getXPosition() {
        return xPosition;
    }

    // Gets the coordinates of the particle
    public double getYPosition() {
        return yPosition;
    }

    // Sets the length of the vector of the particle 
    public void setLength(int length) {
        movementLength = length;
    }

    // Gets the length of the vector of the particle
    public int getLength() {
        return movementLength;
    }

    // Gets information about the movability of the particle
    public boolean isMovable() {
        return isMovable;
    }

    // Sets if the particle is movable or not
    public void setMovable(boolean movable) {
        isMovable = movable;
    }
}