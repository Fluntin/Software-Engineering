import java.util.ArrayList;

// This class is responsible for the movement of the particles
// and the simulation time of the program (how many times the particles move) 
public class ParticleModel {
    private ArrayList<Particle> particles = new ArrayList<>();
    private int simulationTime = 50;

    ParticleModel() {
        int totalParticles = 10000;
        for (int i = 0; i < totalParticles; i++) {
            particles.add(new Particle());
        }
    }

    // Moves all the particles in the simulation
    // if they are movable (not stuck in the boundary)
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