import java.util.*;
class Generera {
    public static void main(String[] args) {

	HashSet<Integer> hset = new HashSet<Integer>();

	int goal = 5;
	int range = 10;
	
	if (args.length > 0)
	    goal = Integer.parseInt(args[0]);
	if (args.length > 1)
	    range = Integer.parseInt(args[1]);

	int tries = 0;
	while (hset.size() < goal) {
	    int next = (int)(Math.random()*range + 1);
	    hset.add(next);
	    tries++;
	}

	
	System.out.println();
	System.out.println( tries + " numbers were tried");
	System.out.println("The " + goal + " different numbers are ");
	for (int i:hset)
	    System.out.print(i + " ");
	System.out.println();
    }
}
