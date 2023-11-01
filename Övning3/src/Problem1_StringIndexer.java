import java.util.HashMap;

public class Problem1_StringIndexer {

    // This method finds the index of a given string in a HashMap.
    // If the string is not found, it returns -1.
    public static int index(String searchString, HashMap<String, Integer> indexMap) {
        // Try to retrieve the index associated with the input string.
        Integer result = indexMap.get(searchString);
        
        // If the string is not in the map, return -1 to indicate it was not found.
        if (result == null) {
            return -1;
        }
        
        // If the string was found, return its index as an integer.
        return result.intValue();
    }

    public static void main(String[] args) {
        // Create a HashMap to store strings and their corresponding indices.
        HashMap<String, Integer> indexMap = new HashMap<String, Integer>();
        String[] stringsToIndex = {"STEN", "SAX", "PÅSE"};

        // Populate the indexMap with strings as keys and their indices as values.
        for (int i = 0; i < stringsToIndex.length; i++) {
            indexMap.put(stringsToIndex[i], i);
        }

        // Find the indices of two example strings: "SAX" and "HOPP".
        int index1 = index("SAX", indexMap);
        int index2 = index("HOPP", indexMap);

        // Print the results to the console.
        System.out.println("Index of 'SAX': " + index1);  // Should print "Index of 'SAX': 1"
        System.out.println("Index of 'HOPP': " + index2); // Should print "Index of 'HOPP': -1"
    }
}


