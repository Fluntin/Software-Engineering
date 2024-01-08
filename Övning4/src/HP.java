import java.util.HashMap;
public class HP {

    public void skrivUt(String[] orden, HashMap<String, Integer>räknare){
		for(String ord:orden){
		    System.out.println(ord+" "+räknare.get(ord));
		}
	}
	
	public static void main(String[] args){
		HP program=new HP();
		Filläsare läsare=new Filläsare("Testdok.txt");
		Sorterare sorterare=new Sorterare(läsare,program);
		läsare.kopplaSorterare(sorterare);

	}
}
