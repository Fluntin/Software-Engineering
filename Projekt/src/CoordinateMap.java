import java.util.HashMap;

// This class is responsible for the movement of the particles in the simulation 
// and the simulation time of the program (how many times the particles move)
public class CoordinateMap extends HashMap<Coordinate, Integer> {
    @Override
    public boolean containsKey(Object key) {
        key = (Coordinate) key;
        return super.containsKey(key);
    }
}