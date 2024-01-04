public class ParticleSimulation extends Thread {
    ParticleModel particleModel;
    SimulationView simulationView;

    ParticleSimulation(ParticleModel particleModel, SimulationView simulationView) {
        this.particleModel = particleModel;
        this.simulationView = simulationView;
        new Thread(this).start();
    }

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