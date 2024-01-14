import java.util.function.*;

class PureFunction{
    static int blahonga;

    public static void main(String[] args){
	Function <Integer, Integer> enFunktionSomDubblerar = pure_dubblera(10);
	System.out.println(enFunktionSomDubblerar.apply(10));
	System.out.println(evalueraFunktionen(s->s*s, 10));
	
    }

    public static int pure_dubblera(int x) {
	return x*x;
    }

    public static  int icke_pure_funktion(int x) {
	blahonga++;
	return x*blahonga;
    }
    public static Integer evalueraFunktionen (Function <Integer, Integer> enFunktion, int tal){
	return enFunktion.apply(tal);
    }
    
    
}
