abstract class Fordon{
        public abstract void kör();
}

class Båt extends Fordon{
    public void kör(){
	System.out.println("Metoden kör i Båt anropats");
    }	
}

class Bil extends Fordon{
    public void kör(){
	System.out.println("Metoden kör i Bil anropats");
    }	
}

class Lastbil extends Bil{
    /*public void kör(){
	System.out.println("Metoden kör i Lastbil anropats");
	}*/
}

class Main{

    public static void anropa(Fordon fp){
        fp.kör();
    }

    public static void main(String[] args){
	Fordon båt = new Båt();
	Fordon bil = new Bil();
	Bil lastB=new Lastbil(); 
	anropa(båt);
	anropa(bil);
	anropa(lastB);
    }

}
