import java.util.*;

class SpelkortC2 { //implements Comparable{
    String farg;    int valor;

    public SpelkortC2 (String f, int v) {
	farg = f;
	valor = v;
    }

    public boolean equals(Object other) {
	if (!(other instanceof SpelkortC2))
	    return false;
	SpelkortC2 spk = (SpelkortC2) other;
	return farg.equals(spk.farg) && valor== spk.valor;
    }

    public int compareTo(Object otherP){

	SpelkortC2 other=(SpelkortC2) otherP;
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
    
