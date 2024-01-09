package FacadePattern;

public class test {
    public static void main(String[] args) {
        ComputerFacade computerFacade = new ComputerFacade();

        computerFacade.start();
        System.out.println("\n");
        computerFacade.shutdown();
    }
}