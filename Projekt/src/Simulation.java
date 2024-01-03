public class Simulation extends Thread {
    Model model;
    View view;

    Simulation(Model model, View view) {
        this.model = model;
        this.view = view;
        new Thread(this).start();
    }

    public void run() {
        while (true) {
            try {
                sleep(model.getTime());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            model.moveParticles();
            view.repaint();
        }
    }
}




