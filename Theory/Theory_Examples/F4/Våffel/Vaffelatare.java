public class Vaffelatare extends Thread {

    private String namn;
    private int antalV = 0;
    private Upplaggsfat fat;

    public Vaffelatare(String namn, Upplaggsfat fat) {
	this.namn = namn;
	this.fat = fat;
    }
	
    public void run() {
	while (!fat.vafflorSlut()) {
	    int vaffla = fat.tag();
	    if (vaffla == 0)
		break;
	    System.out.println(namn + " tar vaffla "+vaffla);
	    Vaffelkalas.slumpvanta(Vaffelkalas.AT_TID);
	    System.out.println(namn + " har atit upp vaffla "+vaffla);
	    antalV++;
	}
	System.out.println(namn + " atit klart");
    }

    public String toString () {
	return namn + " fick " + antalV + " vafflor";
    }
}