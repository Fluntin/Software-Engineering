package FacadePattern;

class CPU {
    public void start() {
        System.out.println("CPU started");
    }

    public void shutdown() {
        System.out.println("CPU shut down");
    }
}

class Memory {
    public void start() {
        System.out.println("Memory started");
    }

    public void shutdown() {
        System.out.println("Memory shut down");
    }
}

class HardDrive {
    public void start() {
        System.out.println("HardDrive started");
    }

    public void shutdown() {
        System.out.println("HardDrive shut down");
    }
}


public class ComputerFacade {
    private CPU cpu = new CPU();
    private Memory memory = new Memory();
    private HardDrive hardDrive = new HardDrive();

    public ComputerFacade() {}

    public void start() {
        cpu.start();
        memory.start();
        hardDrive.start();
        System.out.println("Startup done!");
    }

    public void shutdown() {
        cpu.shutdown();
        memory.shutdown();
        hardDrive.shutdown();
        System.out.println("Shut down done!");
    }
}