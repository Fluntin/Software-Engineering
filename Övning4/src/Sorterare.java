import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;


public class Sorterare implements Runnable {
	Filläsare läsare;
	HP ägare;
	String nyttOrd;
	HashMap<String,Integer> räknare;
	
	public Sorterare(Filläsare läsare, HP ägare){
		räknare=new HashMap<String, Integer>();
		this.läsare=läsare;
		this.ägare=ägare;
		new Thread(this, "Sorterare").start();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
			update();
			while(!"".equals(nyttOrd)){
				if(räknare.containsKey(nyttOrd)){
					räknare.put(nyttOrd, new Integer(räknare.get(nyttOrd)+1));
				}
				else{
					räknare.put(nyttOrd, new Integer(1));
				}
				synchronized(läsare){
					läsare.notify();
				}
				update();
			}
			String[] ord=räknare.keySet().toArray(new String[0]);
			Arrays.sort(ord);
			ägare.skrivUt(ord, räknare);
			synchronized(läsare){
				läsare.notify();
			}
	}
	
	public void update(){
		nyttOrd=null;
        try {
    		synchronized(this){
    			wait();
    		}
        } 
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        nyttOrd=läsare.aktuellText;
	}
}
