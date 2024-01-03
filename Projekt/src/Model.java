import java.util.ArrayList;

public class Model {
    private ArrayList<Particle> particles = new ArrayList<>();
    private int time = 50;
    private int length = 3;

    Model() {
        int totalParticles = 10000;
        for (int i = 0; i < totalParticles; i++) {
            particles.add(new Particle());
        }
    }

    public void moveParticles() {
        for (Particle particle : particles) {
            if (particle.isMovable()) {
                particle.randomMove();
            }
        }
    }

    public void setLength(int length) {
        for (Particle particle : particles) {
            if (particle.isMovable()) {
                particle.changeLength(length);
            }
        }
    }

    public int getLength() {
        return particles.get(0).getLength();
    }

    public void setTime(int t) {
        time = t;
    }

    public int getTime() {
        return time;
    }

    public ArrayList<Particle> getParticles() {
        return particles;
    }
}




