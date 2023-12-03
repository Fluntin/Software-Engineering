import java.util.*;

class Main {

  public static void main(String[] args) {
    // Create a new VecElements instance for storing Integer elements
    VecElements<Integer> vector = new VecElements<>();
    // Add elements to the vector
    vector.add(0, 1720);
    vector.add(1, 1700);
    vector.add(3, 1900);

    // Print the vector
    System.out.println(vector.toString());
    // Convert the vector to an array and print the third element
    Object[] array = vector.toArray();
    System.out.println(array[2]);

    // Sort the values in the vector and print them
    vector.sortedValues();
  }
}

