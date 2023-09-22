public class Vaffelgraddare extends Thread{

    private Upplaggsfat fat;

    Vaffelgraddare(Upplaggsfat fat) {
	this.fat = fat;
    }

    public void run(){
	for(int vaffla=1; vaffla <= Vaffelkalas.ANTAL_VAFFLOR; vaffla++){
	    System.out.println("Graddar vaffla "+vaffla);
	    Vaffelkalas.slumpvanta(Vaffelkalas.GRADDNINGSTID);
	    fat.lagg(vaffla);
	    System.out.println("Graddat vaffla "+vaffla);
	}
    }
}
