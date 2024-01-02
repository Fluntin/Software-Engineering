import java.util.*;
class JamforSpelkortC2 {
    public static void main(String[] u) {
	
	String[] farger = {"Hjarter", "Spader", "Ruter", "Klover"};
	ArrayList kortlek = new ArrayList();

	for (String farg : farger)
	    for (int valor = 1 ; valor <= 13; valor++)
		kortlek.add(new SpelkortC2(farg,valor));

	Collections.sort(kortlek);

	for (Object spk : kortlek)
	    System.out.println(spk);
	System.out.println();
	
	//System.exit(0);
	SpelkortC2 kort1 = new SpelkortC2("Hjärter",3);
	SpelkortC2 kort2 = new SpelkortC2("Klöver",4);
	SpelkortC2 kort3 = new SpelkortC2("Hjärter",2);
	SpelkortC2 kort4 = new SpelkortC2("Ruter",2);

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
