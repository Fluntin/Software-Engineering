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