import java.util.ArrayList;

public class ParticleModel {
    private ArrayList<Particle> particles;
    private int simulationTime = 50;
    private final int totalParticles = 10000;

    public ParticleModel() {
        reset();
    }

    public void reset() {
        particles = new ArrayList<>();
        for (int i = 0; i < totalParticles; i++) {
            particles.add(new Particle());
        }
        simulationTime = 50; // Reset to the default simulation time
        // Reset other state variables if needed
    }

    public void moveAllParticles() {
        for (Particle particle : particles) {
            if (particle.isMovable()) {
                particle.moveRandomly();
            }
        }
    }

    // Sets the length of the vector of all the particles in the simulation 
    // if they are movable (not stuck in the boundary)
    public void setVectorLength(int length) {
        for (Particle particle : particles) {
            if (particle.isMovable()) {
                particle.setLength(length);
            }
        }
    }

    // Sets the simulation time of the program (how many times the particles move)
    // if they are movable (not stuck in the boundary)
    public int getVectorLength() {
        return particles.get(0).getLength();
    }

    // Sets the simulation time of the program (how many times the particles move)
    public void setSimulationTime(int time) {
        simulationTime = time;
    }

    // Gets the simulation time of the program (how many times the particles move)
    public int getSimulationTime() {
        return simulationTime;
    }

    // Gets all the particles in the simulation
    public ArrayList<Particle> getAllParticles() {
        return particles;
    }
 
}