package Extra;

import java.util.ArrayList;

public class Leaf extends Component {

    private String name;
    private double weight;

    Leaf(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    Leaf(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;    }

    @Override
    public boolean hasChildren() {
        return false;
    }

    @Override
    public ArrayList<Component> getChildren() {
        return null;
    }


}
