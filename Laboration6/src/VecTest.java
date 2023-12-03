import static org.junit.Assert.*;
import org.junit.Test;

public class VecTest {

    @Test
    public void testInitialVectorProperties() {
        Vec<Integer> vector = new Vec<>();
        // Test initial state of the vector
        assertEquals("Initial size should be 0", 0, vector.size());
        assertEquals("Minimum index should be -1 for an empty vector", -1, vector.minIndex());
        assertNull("Getting an element from an empty vector should return null", vector.get(3));
        assertTrue("Sorted values of an empty vector should be empty", vector.sortedValues().isEmpty());
        assertNull("Array representation of an empty vector should be null", vector.toArray());
    }

    @Test
    public void testAddingAndRemovingElements() {
        Vec<Integer> vector = new Vec<>();

        // Adding elements at specified positions
        vector.add(0, 1900);
        assertEquals("Size should be 1 after adding one element", 1, vector.size());
        vector.add(1, 1901);
        vector.add(50, 2079);
        vector.add(7, 1601);
        vector.add(13, 1400);
        assertEquals("Size should be 5 after adding five elements", 5, vector.size());

        // Replacing an existing element
        vector.add(13, 1500);
        assertEquals("Size should remain 5 after replacing an element", 5, vector.size());
        assertEquals("Minimum index should be 0", 0, vector.minIndex());
        assertEquals("Maximum index should be 50", 50, vector.maxIndex());

        // Adding an element without specifying position
        vector.add(5000);
        assertEquals("Size should be 6 after adding another element", 6, vector.size());
        assertEquals("Element at index 2 should be 5000", Integer.valueOf(5000), vector.get(2));
        assertNull("Element at an unoccupied index should be null", vector.get(19));

        // Removing elements
        vector.removeAt(0);
        assertEquals("Size should be 5 after removing one element", 5, vector.size());
        assertEquals("Minimum index should now be 1", 1, vector.minIndex());

        vector.removeAt(50);
        assertEquals("Size should be 4 after another removal", 4, vector.size());
        assertEquals("Maximum index should now be 17", 17, vector.maxIndex());

        // Removing an element by value
        vector.removeElem(6000);
        assertEquals("Size should be 3 after removing element 6000", 3, vector.size());
        assertNull("Element 6000 should no longer be in the vector", vector.get(17));
    }

    @Test
    public void testStringVectorFunctionality() {
        Vec<String> vector = new Vec<>();
        vector.add(0, "Hello");
        vector.add(1, "World");

        assertEquals("Index of 'Hello' should be 0", 0, vector.indexOf("Hello"));
        assertEquals("Element at index 0 should be 'Hello'", "Hello", vector.get(0));
    }
}

