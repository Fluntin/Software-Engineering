import java.util.HashMap;
//--------------------------------------------------------------------------------------------
// This class is tailored specifically for handling a map where:
// Keys are instances of the Coordinate class
// Values are Integer objects.
//--------------------------------------------------------------------------------------------
public class CoordinateMap extends HashMap<Coordinate, Integer> {
    @Override
    public boolean containsKey(Object key) {
        key = (Coordinate) key;
        return super.containsKey(key);
    }
}

//--------------------------------------------------------------------------------------------
//NOTE:
//The casting of the key to Coordinate (key = (Coordinate) key;) is unsafe. 
//If a non-Coordinate object is passed as a key to this method, it will throw a ClassCastException.
//This is a known issue and is not a problem for this project.
//--------------------------------------------------------------------------------------------