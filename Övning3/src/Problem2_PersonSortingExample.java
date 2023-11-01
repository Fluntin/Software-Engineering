import java.util.*;

class Person implements Comparable<Person> {
    long pnr;
    String namn;

    Person(long p, String n) {
        pnr = p;
        namn = n;
    }

    public String toString() {
        return namn + " " + pnr;
    }

    @Override
    public int compareTo(Person other) {
        return (int) (this.pnr - other.pnr);
    }
}

public class Problem2_PersonSortingExample {
    public static void main(String[] args) {
        // b. Create a sorted tree of Person objects
        TreeSet<Person> personerna = new TreeSet<Person>();

        // Simulated method for creating Person objects
        Person person = skapaPerson();
        while (person != null) {
            personerna.add(person);
            person = skapaPerson(); // Assuming skapaPerson() creates a new Person
        }

        // c. Print the elements of the TreeSet in sorted order
        Iterator<Person> iter = personerna.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }

        // d. Sort a list of Person objects in personnummerordning
        List<Person> plista = new ArrayList<>();
        // Populate plista with Person objects

        Collections.sort(plista);

        // e. Create a new list of Person objects sorted by namn while preserving the original order by pnr
        List<Person> sortedByName = new ArrayList<>(plista);
        Collections.sort(sortedByName, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return p1.namn.compareTo(p2.namn);
            }
        });
    }

    // Simulated method to create a Person object (you should replace this with your logic)
    private static Person skapaPerson() {
        // Simulated logic to create a Person object
        // Replace this with your actual code to create a Person object
        return null; // Change this to return a new Person object
    }
}
