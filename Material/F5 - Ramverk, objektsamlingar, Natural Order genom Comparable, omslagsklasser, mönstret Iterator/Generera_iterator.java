import java.util.*;

class MyIterator implements Iterable<Integer>, Iterator<Integer>{
    HashSet<Integer> hset = new HashSet<Integer>();
    
    int goal = 5;
    int range = 10;
    	
    int tries = 0;

    public Iterator<Integer> iterator(){
	return this;
    }
    
    public boolean hasNext(){
	System.out.println( hset.size() < goal);
	return hset.size() < goal;
    }

    public Integer next(){
	while (hset.size() < goal) {
	    int next = (int)(Math.random()*range + 1);
	    if (hset.add(next))
		return new Integer(next);
	    tries++;
	}
	return 0;
    }
    

}


class Generera_iterator {
    public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);

	MyIterator generator =new MyIterator();
	//	System.out.println()

	for (Integer i:generator){
	    System.out.print(i + " ");
	    System.out.println(generator.hset.size());
	    sc.nextLine();
	}
	System.out.println();
    }
}
