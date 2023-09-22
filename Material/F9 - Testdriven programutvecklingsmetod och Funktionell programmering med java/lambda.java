import java.util.function.*;

class Lambda{

    public static void main(String[] args){
	Function <Integer, Double> cirkelOmkrets = radie -> 2*3.14*radie;



	//	Function <Integer,Double> cirkelOmkrets = (radie)->{double omkrets= 2*3.14*radie;  return omkrets;};
	Object enAnnanReferens = cirkelOmkrets;

       	System.out.println(((Function <Integer,Double>)enAnnanReferens).apply(12));
	System.out.println(cirkelOmkrets.apply(12));
	System.out.println(cirkelOmkrets.apply(120));
	//	System.out.println(((Function <Integer,Double>)radie ->2*3.14*radie).apply(12));
	//System.out.println(((Function <Integer,Double>)radie ->2*3.14*radie));
	
	
    }

}
