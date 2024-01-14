class Bok extends Skrift{

    Bok(String n){
	namn=n;
    }
    
    public String toString(){
	return namn;
    }
    
    public static void main(String[] args){
	Bok b = new Bok("Pippi",120);
	System.out.println(b);
    }
}
