import java.util.*;
import java.lang.StringBuilder;

class VecElements<E extends Comparable<E>> implements SparseVec<E> {

    // TreeMap to store elements with their indices
    private TreeMap<Integer, E> tree = new TreeMap<>();

    // Main method for demonstration and testing
    public static void main(String[] args) {
        VecElements<Integer> vec = new VecElements<>();
        // Adding elements to the vector
        vec.add(0, 5000);
        vec.add(17, 3000);
        vec.add(21, 3050);
        vec.add(3, 10000);
        vec.add(7, 900);

        // Displaying the vector
        System.out.println(vec);
        // Converting to array and displaying
        Object[] arr = vec.toArray();
        List<Integer> values = vec.sortedValues();
        System.out.println(values);

        // Testing and displaying the result of toArray()
        int i = 0;
        for (Object o : arr) {
            System.out.print(o);
            System.out.println(" " + i++);
        }
    }

    // Adds an element at the lowest unoccupied index
    public void add(E elem) {
        Set<Map.Entry<Integer, E>> mappings = this.tree.entrySet();
        Iterator<Map.Entry<Integer, E>> itr = mappings.iterator();

        int lowestIndex = 0; // Start with the assumption that the lowest index is 0
        while (itr.hasNext()) {
            int key = itr.next().getKey();
            if (lowestIndex == key) lowestIndex++;
            else break; // Found the lowest unoccupied index
        }
        this.tree.put(lowestIndex, elem);
    }

    // Adds or replaces an element at the specified position
    public void add(int pos, E elem) {
        this.tree.put(pos, elem);
    }

    // Finds the first occurrence of an element and returns its index
    public int indexOf(E elem) {
        for (Map.Entry<Integer, E> entry : this.tree.entrySet()) {
            if (elem.compareTo(entry.getValue()) == 0) {
                return entry.getKey();
            }
        }
        return -1; // Element not found
    }

    // Removes the element at the specified position
    public void removeAt(int pos) {
        this.tree.remove(pos);
    }

    // Removes the first occurrence of the specified element
    public void removeElem(E elem) {
        int pos = this.indexOf(elem);
        if (pos != -1) {
            this.removeAt(pos);
        }
    }

    // Returns the size of the vector
    public int size() {
        return this.tree.size();
    }

    // Returns the lowest index in use, or -1 if the vector is empty
    public int minIndex() {
        return this.size() == 0 ? -1 : this.tree.firstKey();
    }

    // Returns the highest index in use, or -1 if the vector is empty
    public int maxIndex() {
        return this.size() == 0 ? -1 : this.tree.lastKey();
    }

    // Returns a string representation of the vector
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Map.Entry<Integer, E> entry : this.tree.entrySet()) {
            s.append("Key: ").append(entry.getKey()).append(" Value: ").append(entry.getValue()).append("\n");
        }
        return s.toString();
    }

    // Returns the element at the specified position, or null if not available
    public E get(int pos) {
        return this.tree.get(pos);
    }

    // Converts the sparse vector to a regular array
    public Object[] toArray() {
        if (this.size() == 0) return null;

        Object[] arr = new Object[this.maxIndex() + 1];
        for (Map.Entry<Integer, E> entry : this.tree.entrySet()) {
            arr[entry.getKey()] = entry.getValue();
        }
        return arr;
    }

    // Returns a list of the values in sorted order
    public List<E> sortedValues() {
        List<E> values = new ArrayList<>(this.tree.values());
        Collections.sort(values);
        return values;
    }
}

