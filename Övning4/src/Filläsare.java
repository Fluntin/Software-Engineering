import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Filläsare implements Runnable {
	Scanner in;
	public String aktuellText;
	Sorterare sorterare;
	
	
	
	public Filläsare(String filnamn){//, Sorterare sorterare){
		try{
			in=new Scanner(new File(filnamn));
			in.useDelimiter("[^a-zA-ZåäöÅÄÖ]");
		}
		catch(FileNotFoundException e){
			System.out.println("Filen saknas");
		}
	}
	
	public void kopplaSorterare(Sorterare sorterare){
		this.sorterare=sorterare;
		new Thread(this,"läsare").start();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
			while (in.hasNext()){
				aktuellText=in.next();
				while("".equals(aktuellText)&&in.hasNext()){
					aktuellText=in.next();
				}
				if (aktuellText!=null){
					updatera();
				}				
			}
			synchronized(sorterare){
				sorterare.notify();
			}
	}
	
	public void updatera(){
			synchronized(sorterare){
				sorterare.notify();
			}
			try {
				synchronized(this){
					wait();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}		
	}
}
