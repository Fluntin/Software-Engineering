import java.util.Arrays;
import java.util.HashMap;

public class Sorterare implements Runnable {
    Filläsare läsare;
    HP ägare;
    String nyttOrd;
    HashMap<String, Integer> räknare;

    public Sorterare(Filläsare läsare, HP ägare) {
        räknare = new HashMap<>();
        this.läsare = läsare;
        this.ägare = ägare;
        new Thread(this, "Sorterare").start();
    }

    @Override
    public void run() {
        update();
        while (!"".equals(nyttOrd)) {
            // Synchronize access to the räknare HashMap
            synchronized (räknare) {
                räknare.put(nyttOrd, räknare.getOrDefault(nyttOrd, 0) + 1);
            }

            // Notify the läsare (reader) thread to continue reading
            synchronized (läsare) {
                läsare.notify();
            }

            update();
        }

        String[] ord;
        // Synchronize access to the räknare HashMap while getting the keys
        synchronized (räknare) {
            ord = räknare.keySet().toArray(new String[0]);
        }
        Arrays.sort(ord);
        ägare.skrivUt(ord, räknare);

        // Notify the läsare (reader) thread to continue reading
        synchronized (läsare) {
            läsare.notify();
        }
    }

    public void update() {
        nyttOrd = null;
        try {
            synchronized (this) {
                wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        nyttOrd = läsare.aktuellText;
    }
}

