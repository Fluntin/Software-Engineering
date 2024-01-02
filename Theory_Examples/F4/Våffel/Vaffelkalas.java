public class Vaffelkalas {

    public static int ANTAL_VAFFLOR = 20;
    public static int GRADDNINGSTID = 3000; // maxtid
    public static int AT_TID = 1200; // maxtid

    private Upplaggsfat fat = new Upplaggsfat();
    
    public Vaffelkalas () {

	// Borja gradda 
        new Vaffelgraddare(fat).start();

        Vaffelatare anna = new Vaffelatare("Anna",fat);
        Vaffelatare magnus = new Vaffelatare("Magnus",fat);
        Vaffelatare tomas = new Vaffelatare("Tomas",fat);

	// Borja ata
	anna.start(); magnus.start(); tomas.start();

	// Vanta tills alla atit klart
	try {
	    anna.join();
	    magnus.join();
	    tomas.join();
	}
	catch (InterruptedException e) {}

	// Vi far veta hur manga vafflor var och en fick
	System.out.println();
	System.out.println(anna);
	System.out.println(magnus);
	System.out.println(tomas);
    }

    public static void slumpvanta(int ms){
        try {
	    Thread.sleep((int)(ms*Math.random()));
	}
        catch(InterruptedException e){
	    System.err.println("Somnbrott");
	}
    }

    public static void vanta(int ms){
        try {
	    Thread.sleep(ms);}
        catch(InterruptedException e){
	    System.err.println("Somnbrott");
	}
    }

    public static void main(String[] args) {
	new Vaffelkalas();
    }
}


/*
Graddar vaffla 1
Graddat vaffla 1
Graddar vaffla 2
Anna tar vaffla 1
Anna har atit upp vaffla 1
Graddat vaffla 2
Tomas tar vaffla 2
Graddar vaffla 3
Tomas har atit upp vaffla 2
Graddat vaffla 3
Anna tar vaffla 3
Graddar vaffla 4
Anna har atit upp vaffla 3
Graddat vaffla 4
Tomas tar vaffla 4
Graddar vaffla 5
Tomas har atit upp vaffla 4
Graddat vaffla 5

   << hoppar over en hel del >>

Tomas har atit upp vaffla 19
Graddat vaffla 20
Tomas atit klart
Magnus tar vaffla 20
Anna atit klart
Magnus har atit upp vaffla 20
Magnus atit klart

Anna fick 5 vafflor
Magnus fick 8 vafflor
Tomas fick 7 vafflor

*/
