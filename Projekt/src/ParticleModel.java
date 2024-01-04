import java.util.ArrayList;

public class ParticleModel {
    private ArrayList<Particle> particles = new ArrayList<>();
    private int simulationTime = 50;

    ParticleModel() {
        int totalParticles = 10000;
        for (int i = 0; i < totalParticles; i++) {
            particles.add(new Particle());
        }
    }

    public void moveAllParticles() {
        for (Particle particle : particles) {
            if (particle.isMovable()) {
                particle.moveRandomly();
            }
        }
    }

    public void setVectorLength(int length) {
        for (Particle particle : particles) {
            if (particle.isMovable()) {
                particle.setLength(length);
            }
        }
    }

    public int getVectorLength() {
        return particles.get(0).getLength();
    }

    public void setSimulationTime(int time) {
        simulationTime = time;
    }

    public int getSimulationTime() {
        return simulationTime;
    }

    public ArrayList<Particle> getAllParticles() {
        return particles;
    }
}