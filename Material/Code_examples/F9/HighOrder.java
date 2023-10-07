import java.util.function.*;

class HighOrder{

    public static void main(String[] args){
	Function <Integer, Integer> enFunktionSomDubblerar = dubblera();
	System.out.println(enFunktionSomDubblerar.apply(10));
	System.out.println(evalueraFunktionen(s->s*s, 10));
	
    }

    public static Function <Integer, Integer> dubblera() {
	return n -> 2*n;
    }
    
    public static Integer evalueraFunktionen (Function <Integer, Integer> enFunktion, int tal){
	return enFunktion.apply(tal);
    }
    
    
}
