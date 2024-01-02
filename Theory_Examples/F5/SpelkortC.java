import java.util.*;
class SpelkortC implements Comparable <SpelkortC> {
    String farg;    int valor;

    public SpelkortC (String f, int v) {
	farg = f;
	valor = v;
    }

    public boolean equals(Object other) {
	if (!(other instanceof SpelkortC))
	    return false;
	SpelkortC spk = (SpelkortC) other;
	return farg.equals(spk.farg) && valor== spk.valor;
    }

    public int compareTo(SpelkortC other){
	
        if (this.equals(other)) return 0;     // assumes equals() defined
        if (this.valor == other.valor) return // if same valor, let color
	    this.farg.compareTo(other.farg);  // decide
        if (other.valor == 1 ||               // other is ace OR
	    this.valor > 1 && this.valor < other.valor)  
	    return -1;   // I am not ace and other is higher
        return 1;
    }

    
    public String toString() {
	String valorString;
	if (valor == 1)
	    valorString = specvalor[0];
	else if (valor <= 10)
            valorString = " " + valor;
	else 
            valorString = specvalor[valor-10];

        return farg + " " + valorString;
    }

    /*********************************
     *  Objektmall ovanfor           *
     *  Klassgemensamt nedanfor      *
     *********************************/

    static String[] specvalor = 
        {"ESS", "KNEKT", "DAM", "KUNG"};
}
    
