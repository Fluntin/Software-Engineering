import java.util.*;
class JamforSpelkortC {
    public static void main(String[] u) {

	String[] farger = {"Hjarter", "Spader", "Ruter", "Klover"};
	ArrayList<SpelkortC> kortlek = new ArrayList<SpelkortC>();

	for (String farg : farger)
	    for (int valor=1; valor<=13; valor++)
		kortlek.add(new SpelkortC(farg,valor));

	Collections.sort(kortlek);

	for (SpelkortC spk : kortlek)
	    System.out.println(spk);
	System.out.println();

	//System.exit(0);
	SpelkortC kort1 = new SpelkortC("Hjärter",12);
	SpelkortC kort2 = new SpelkortC("Klöver",1);
	SpelkortC kort3 = new SpelkortC("Hjärter",2);
	SpelkortC kort4 = new SpelkortC("Ruter",2);

	System.out.println();
	System.out.print(kort1 + "\t" + kort2 + "  \t" + kort1.compareTo(kort2));
	System.out.println();
	System.out.print(kort1 + "\t" + kort3 + "  \t" + kort1.compareTo(kort3));
	System.out.println();
	System.out.print(kort2 + "\t" + kort3 + "  \t" + kort2.compareTo(kort3));
	System.out.println();
	System.out.print(kort3 + "\t" + kort4 + "  \t" + kort3.compareTo(kort4));
	System.out.println();
    }
}
