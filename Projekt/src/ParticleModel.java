import java.util.ArrayList;

//--------------------------------------------------------------------------------------------
// ACTS AS A CONTROLLER 
// Manages a collection of particles, controls their movement
// maintains simulation settings such as simulation time and vector length.
// Encapsulates the behavior and state of the entire particle system
//--------------------------------------------------------------------------------------------
// It is responsible for:
// 1. Initializing the particles, 
// 2. Update their state, 
// 3. Provide accessors to modify and retrieve simulation parameters
//--------------------------------------------------------------------------------------------
public class ParticleModel {
    private ArrayList<Particle> particles; // Collection of particles in the simulation
    private int simulationTime = 50; // Milliseconds
    private final int totalParticles = 10000; // Total number of particles in the simulation

    public ParticleModel() {
        reset();
    }

    public void reset() {
        particles = new ArrayList<>();
        for (int i = 0; i < totalParticles; i++) {
            particles.add(new Particle());
        }
        simulationTime = 50;
    }

    // Moves all particles in the simulation
    // Only movable particles are moved!
    public void moveAllParticles() {
        for (Particle particle : particles) {
            if (particle.isMovable()) {
                particle.moveRandomly();
            }
        }
    }

    // Sets the length of the vector of all particles
    // Only movable particles are affected!
    public void setVectorLength(int length) {
        for (Particle particle : particles) {
            if (particle.isMovable()) {
                particle.setLength(length);
            }
        }
    }

    // Gets the length of the vector of all particles
    public int getVectorLength() {
        return particles.get(0).getLength();
    }

    // Sets the simulation time
    public void setSimulationTime(int time) {
        simulationTime = time;
    }

    // Gets the simulation time
    public int getSimulationTime() {
        return simulationTime;
    }

    // Gets all particles in the simulation
    public ArrayList<Particle> getAllParticles() {
        return particles;
    }
 
}