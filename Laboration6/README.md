# Lab 6 - ADT and Testing

## Objectives
- Apply basic unit testing using the JUnit testing framework.
- Use generic types in Java.
- Implement an Abstract Data Type (ADT) using the Map data type in various ways.
- Efficiently use Map and Set implementations by reading and interpreting the Java API documentation.

## Prerequisites
This instruction assumes that the programs are run in a terminal window on the school's Unix computers by logging in to a Ubuntu computer lab or by connecting to a server such as student-shell-1.sys.kth.se using your own computer and SSH. It is allowed to run JUnit through an IDE or download the JAR files on your computer, but we cannot provide guidance for that.

Here is Oracle's page with a tutorial on generic types: [Generic Types](Links to an external site.). It is sufficient to read the starting page and some information about Bounded Type. Refer to the left column in the tutorial. There are also examples with generic typing in the lecture slides for Lecture 5. In the same lecture, there is an explanation of Comparable, which should be used in task 1.

You can find a tutorial for JUnit [here](Links to an external site.). Please note that only JUnit 4 is available on the school's computers.

## Task 1 - Numbered Object
Implement a small class called NumberedItem where an object of any type can be stored along with an integer index.

Requirements for the class:
- Two attributes, an integer (int) and an attribute of generic type T. Both should be initialized in the constructor. The integer should be interpreted as an index.
- If the integer parameter to the constructor (the index) is negative (i.e., less than 0), store 0 as the index attribute.
- The constructor's second parameter should be of type T.
- The class declaration should start with `class NumberedItem<T>`.
- Objects of NumberedItem should be comparable to other objects of the same type, e.g., for automatic sorting within the Java Collections framework. Only the integer attribute (which is guaranteed to be an integer) should be used in the comparison. Let the comparison method return the difference between the indices.
- Implement a `toString()` method that prints, for example, "Index: 42 Value: 1729".
- Note that T is the name of a formal parameter for the type. T does not refer to a class named T.

Once the class compiles without errors, run the following JUnit test class on NumberedItem. You can download it here: [NumberedItemTest0.java](NumberedItemTest0.java).

```java
import static org.junit.Assert.*;
import org.junit.Test;

public class NumberedItemTest0 {

    @Test
    public void testCompare() {
        NumberedItem<Integer> i1 = new NumberedItem<>(-1, 1);   // note the diamond syntax
        NumberedItem<Integer> i2 = new NumberedItem<>(0, 17);
        NumberedItem<Integer> i3 = new NumberedItem<>(5, 100);
        NumberedItem<Integer> i4 = new NumberedItem<>(10, 378);
        assertEquals(0, i1.compareTo(i2));
        assertEquals(-5, i3.compareTo(i4));
        assertEquals(5, i4.compareTo(i3));
    }
}
```

To compile the test class on CSC's Ubuntu computers, use the following command:

```shell
javac -classpath /usr/share/java/junit4.jar:. NumberedItemTest0.java
```

Now, run the test class with the following command:

```shell
java -classpath /usr/share/java/junit4.jar:. org.junit.runner.JUnitCore NumberedItemTest0
```

If you are running the test on your own computer and have downloaded junit-4.13.2.jar, you may encounter an error indicating that java cannot find `org/hamcrest/Selfdescribing`. In that case, download hamcrest-core-1.3.jar and run the following command:

```shell
java -cp junit-4.13.2.jar:hamcrest-core-1.3.jar:. org.junit.runner.JUnitCore NumberedItemTest0
```

If the tests fail, make the necessary changes to NumberedItem and rerun the tests until they pass.

## Task 2 - Sparse Vector
In this task, you should create a class that manages a sparse vector with elements of almost any type. In a regular array (or vector), all indexes from 0 up to an upper limit are used. However, in this task, you should allow objects to be stored together with an index, but not all indexes need to be used consecutively. For example, you should be able to add an element at position 3, then one at position 14, and another at position 7 without using the unused indexes. In an ADT for this purpose, you don't need to specify how empty positions are handled, but the implementation here should be smart enough so that unused indexes don't take up any space, except if you request such a representation through a method call. "Almost any type" refers to the fact that we restrict the element type to objects that can be compared, i.e., they should implement the Comparable interface. This restriction is expressed by specifying a bounded type parameter for the type, using `E extends Comparable<E>`.

Here is an interface for the sparse vector:

```java
import java.util.*;
public interface SparseVec<E extends Comparable<E>> {
    public void add(E elem);           // add at the lowest index >= 0 that is not already occupied                                              
    public void add(int pos, E elem);  // add elem at pos, if pos is occupied replace it with elem, if pos<0, use index = 0        
    public int indexOf(E elem);        // find the first (lowest index) occurrence of elem and return its index, if not found, return -1                                                              
    public void removeAt(int pos);     // if index pos is not used, nothing happens                                            
    public void removeElem

(E elem);    // remove the first occurrence (lowest index) of elem                                        
    public int size();
    public int minIndex();             // return the lowest index in use, if the vector is empty, return -1                                    
    public int maxIndex();             // return the highest index in use, if the vector is empty, return -1                                   
    public String toString();          // provide one line per element with index and value, sorted by index                                                     
    public E get(int pos);             // return null if not available                                                         
    public Object[] toArray();         // return the SparseVector as a regular array with value null at unused indexes                                          
    public List<E> sortedValues();     // return a List of the values of the Vector in sorted order                           
}  
```

You can download the above interface here: [SparseVec.java](SparseVec.java).

The "extends" in "E extends Comparable<E>" specifies a constraint on the parameter E. The actual type E must be a class that implements Comparable (or implements an interface that inherits Comparable). The "extends" keyword has a different meaning here than what we are used to.

### Task 2A - Implementing SparseVec with TreeMap
Write an implementation of the above interface. This implementation should still have a type parameter so that objects of any type that is Comparable can be stored. To store objects and their indexes, sorted by index, use an object of an implementation of the Java interface Map<K, V>, preferably the TreeMap<K, V> class. Much of the functionality required in SparseVec is already available in TreeMap, so read the documentation in the TreeMap<K, V> API carefully to avoid unnecessary work. Also, read the documentation for the Set data type (especially SortedSet), as the set of keys is managed as such. All SparseVec functions can be implemented with just a TreeMap as an attribute. Some methods will require local variables, but that's a different matter.

Tips and requirements for implementation:
- Start the class declaration (after import statements) like this: `class YourClassName<E extends Comparable<E>> implements SparseVec<E>`, where YourClassName is your chosen class name.
- Tips: The following methods can be implemented in one or two lines by directly using TreeMap functionality or combining other SparseVec methods: size(), minIndex(), maxIndex(), removeAt(pos), get(pos), removeElem(elem), add(pos, elem).
- The following methods may require a bit more work: add(elem), indexOf(elem), toString(), toArray(), sortedValues().
- Requirements: For toString(), use the StringBuilder class to build the text, not repeated + between text values. The output should have one line per element, with index and value provided.
- Write a small test class for the class you created.

Tips and requirements for testing:
- Tips: For the tests, you must choose a value for the current type parameter, i.e., a class that implements Comparable. Some simple choices for testing are Integer or String.
- Requirements: For an empty SparseVec, test size(), minIndex(), maxIndex(), all of which should return integer values. Test get(k), where k is an arbitrary int value. Call toArray() on an empty vector and perform appropriate tests on the results.
- Requirements: Add elements at specified positions, some at the same index, and test size() after each insertion. Test the values of minIndex() and maxIndex().
- Requirements: Add elements at unspecified positions. Test size() and get() to ensure they match the expected values. Remember to test get() with an index that is not used; it should return null.
- Requirements: Test both variants of remove and provide tests to demonstrate that they work.
- Requirements: In the main method of the SparseVec implementation, create a vector, insert at least five values, and test toString(), toArray(), and sortedValues() by calling them and printing the results. Do not use JUnit and assert for these tests.

### Task 2B - Implementing SparseVec as a TreeMap
Create a new class by making a copy of the class from 2A. In this new class, inherit from TreeMap and implement SparseVec. Objects of this class will be TreeMap objects. Remove the TreeMap attribute from the class. Depending on how you implemented the class in 2A, a small (but instructive) error may occur.

Copy the test class from 2A and execute the tests.

## How to Submit
- Submit the NumberedItem.java class along with the execution of the provided test case NumberedItemTest.java.
- Submit the class from Task 2A with the accompanying test class according to the requirements mentioned above and execute the tests.
- Submit the class from Task 2B with the accompanying test class according to the requirements mentioned above and execute the tests.
