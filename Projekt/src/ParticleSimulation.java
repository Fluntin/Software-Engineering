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

    //--------------------------------------------------------------------------------------------
    // The simulation runs in a separate thread!
    // We have an infinite loop that updates the particle positions and triggers a repaint of the simulation view
    // We also sleep for a short time to allow the user to see the changes
    // The sleep time is determined by the simulation time
    // The simulation time can be changed by the user through the GUI
    // Where the simulation time is the time between each update of the particle positions
    //--------------------------------------------------------------------------------------------
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

//--------------------------------------------------------------------------------------------
// By extending Thread, ParticleSimulation runs independently of the main GUI thread. 
// This prevents the simulation from freezing or slowing down the user interface and vice versa.
//--------------------------------------------------------------------------------------------