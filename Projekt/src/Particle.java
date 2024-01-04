import java.awt.*;
import java.util.Random;

public class Particle {
    private double xPosition, yPosition, angle;
    private int movementLength = 3;
    private Color color;
    private boolean isMovable = true;

    Particle() {
        color = Color.RED;
        generateRandomAngle();
        Random random = new Random();
        xPosition = 200 * random.nextDouble();
        yPosition = 200 * random.nextDouble();
    }

    private void generateRandomAngle() {
        Random random = new Random();
        angle = 2 * Math.PI * random.nextDouble();
    }

    public void moveRandomly() {
        generateRandomAngle();
        xPosition += movementLength * Math.cos(angle);
        yPosition += movementLength * Math.sin(angle);
    }

    public double getXPosition() {
        return xPosition;
    }

    public double getYPosition() {
        return yPosition;
    }

    public void setLength(int length) {
        movementLength = length;
    }

    public int getLength() {
        return movementLength;
    }

    public boolean isMovable() {
        return isMovable;
    }

    public void setMovable(boolean movable) {
        isMovable = movable;
    }
}