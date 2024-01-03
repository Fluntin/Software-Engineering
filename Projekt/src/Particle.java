import java.awt.*;
import java.util.Objects;
import java.util.Random;

public class Particle {
    private double x, y, theta;
    private int length = 3;
    private Color color;
    private boolean movable = true;

    Particle() {
        color = Color.RED;
        randomTheta();
        Random random = new Random();
        x = 200 * random.nextDouble();
        y = 200 * random.nextDouble();
    }

    private void randomTheta() {
        Random random = new Random();
        theta = 2 * Math.PI * random.nextDouble();
    }

    public void randomMove() {
        randomTheta();
        x = x + length * Math.cos(theta);
        y = y + length * Math.sin(theta);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void changeLength(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public boolean isMovable() {
        return movable;
    }
}


