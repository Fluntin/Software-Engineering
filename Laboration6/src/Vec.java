import java.util.*;
import java.lang.StringBuilder;

class Vec<E extends Comparable<E>> extends TreeMap<Integer, E> implements SparseVec<E> {

  // Main method for demonstration purposes
  public static void main(String[] args) {
    Vec<Integer> vec = new Vec<>();

    vec.add(0, 5000);
    vec.add(17, 3000);
    vec.add(21, 3050);
    vec.add(3, 10000);
    vec.add(7, 900);

    System.out.println(vec);
    Object[] arr = vec.toArray();
    List<Integer> values = vec.sortedValues();
    System.out.println(values);

    // Test result of toArray()
    int i = 0;
    for (Object o : arr) {
      System.out.print(o);
      System.out.println(" " + i++);
    }
  }

  // Adds an element at the lowest unoccupied index
  public void add(E elem) {
    Set<Map.Entry<Integer, E>> entries = this.entrySet();
    Iterator<Map.Entry<Integer, E>> itr = entries.iterator();

    int lowestIndex = 0;
    while (itr.hasNext()) {
      int key = itr.next().getKey();
      if (lowestIndex == key) lowestIndex++;
      else break;
    }
    this.put(lowestIndex, elem);
  }

  // Adds or replaces an element at the specified position
  public void add(int pos, E elem) {
    this.put(pos, elem);
  }

  // Finds the first occurrence of an element and returns its index
  public int indexOf(E elem) {
    for (Map.Entry<Integer, E> entry : this.entrySet()) {
      if (elem.equals(entry.getValue())) {
        return entry.getKey();
      }
    }
    return -1;
  }

  // Removes the element at the specified position
  public void removeAt(int pos) {
    this.remove(pos);
  }

  // Removes the first occurrence of the specified element
  public void removeElem(E elem) {
    int pos = this.indexOf(elem);
    if (pos != -1) {
      this.removeAt(pos);
    }
  }

  // Returns the lowest index in use, or -1 if the vector is empty
  public int minIndex() {
    return this.isEmpty() ? -1 : this.firstKey();
  }

  // Returns the highest index in use, or -1 if the vector is empty
  public int maxIndex() {
    return this.isEmpty() ? -1 : this.lastKey();
  }

  // Returns a string representation of the vector
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (Map.Entry<Integer, E> entry : this.entrySet()) {
      sb.append("Key: ").append(entry.getKey()).append(" Value: ").append(entry.getValue()).append("\n");
    }
    return sb.toString();
  }

  // Converts the sparse vector to a regular array
  public Object[] toArray() {
    if (this.isEmpty()) return null;

    Object[] arr = new Object[this.lastKey() + 1];
    for (Map.Entry<Integer, E> entry : this.entrySet()) {
      arr[entry.getKey()] = entry.getValue();
    }
    return arr;
  }

  // Returns a list of the values in sorted order
  public List<E> sortedValues() {
    List<E> values = new ArrayList<>(this.values());
    Collections.sort(values);
    return values;
  }

  // Returns the element at the specified position, or null if not available
  public E get(int pos) {
    return super.get(pos);
  }
}

