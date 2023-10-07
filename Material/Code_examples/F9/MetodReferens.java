import java.util.function.*;

class MetodReferens{

    public static void main(String[] args){
	System.out.println(enFunktion().apply(10.4f));
	System.out.println(enFunktion().apply(10.9f));
	System.out.println(enAnnanFunktion(Math::getExponent, 5.7f));
	
    }
    
    static  Function<Float,Integer>  enFunktion(){
	return Math::round; 
    }

    
    static Integer enAnnanFunktion(Function<Float, Integer> fnk, float n){
	return fnk.apply(n);
    }



    
}
