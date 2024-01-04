import java.util.HashMap;

public class CoordinateMap extends HashMap<Coordinate, Integer> {
    @Override
    public boolean containsKey(Object key) {
        key = (Coordinate) key;
        return super.containsKey(key);
    }
}
