import java.awt.*;
import java.util.Random;

//--------------------------------------------------------------------------------------------
// Particle -> represent a particle in a simulation environment.
// Contains properties and methods to manage the particle's position, movement, etc...
//-------------------------------------------------------------------------------------------- 

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

    // Generates a random angle between 0 and 2*pi
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