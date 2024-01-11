//--------------------------------------------------------------------------------------------
// Acts as the driving engine of the particle simulation.
// 1. Updates the particle positions and 
// 2. Triggers a repaint of the simulation view
// 3. Sleeps for a short time to allow the user to see the changes
//--------------------------------------------------------------------------------------------

public class ParticleSimulation extends Thread {
    ParticleModel particleModel;
    SimulationView simulationView;

    // Initializing the simulation
    ParticleSimulation(ParticleModel particleModel, SimulationView simulationView) {
        this.particleModel = particleModel;
        this.simulationView = simulationView;
        new Thread(this).start();
    }

    // Running the simulation
    // The simulation runs in a separate thread!
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(particleModel.getSimulationTime());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            particleModel.moveAllParticles();
            simulationView.repaint();
        }
    }
}