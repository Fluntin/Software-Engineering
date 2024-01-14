import java.util.*;

class Active extends Thread{
    String text;
    int pause;
    int n;

    Active(String t,int p){
	text=t;
	pause=p;
	start();
    }

    public void run(){
	while(n<10){
	    
	    try{
		System.out.println("nu kommer jag sova för 1 sekund");
		Thread.sleep(pause*1000);
	    }
	    catch(InterruptedException ie){
		System.err.println("fel"+" "+ie);
	    }
	    System.out.println(text+" "+n);
	    n++;
	}
	System.out.println(text+"finished");
    }
}


class Active2 extends Thread{
    boolean keepRunning = true;
    String text;
    int pause;

    Active2(String t,int p){
	text=t;
	pause=p;
	start();
    }

    public void run(){
	while(keepRunning){
	    try{
		Thread.sleep(pause*1000);
	    }
	    catch(InterruptedException ie){
		System.out.println("fel"+ie);
		keepRunning = false;
	    }
	    System.out.println(text);
	}
	System.out.println(text+" was interruted");
    }
}


class Active3 implements Runnable{
    boolean keepRunning=true;
    String text;
    int pause;
    int n;
    Thread activity;

    Active3(String t,int p){
	text=t;
	pause=p;
	activity = new Thread(this);
	activity.start();
	
    }

    public void run(){
	n=0;
	while(keepRunning){

	    try{
		Thread.sleep(pause*1000);
	    }
	    catch(InterruptedException ie){
		System.out.println("fel"+ie);
		keepRunning = false;
	    }
	    System.out.println(text+":"+n);
	    n++;
	}
	System.out.println(text+"finished");
    }

    public void interrupt(){
	System.out.println("122");
	activity.interrupt();
    }
    
}



class Main{
    public static void main(String[] args){
	Scanner sc=new Scanner(System.in);
	System.out.println("Nu skapas trådarna.");
	Active a1=new Active("Thread1",1);
	Active a2 = new Active("Thread2",2);
	sc.nextInt();
	a1.interrupt();
	sc.nextInt();
	a2.interrupt();
	
    }

}

