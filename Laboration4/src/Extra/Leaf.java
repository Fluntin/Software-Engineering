package Extra;

import java.util.ArrayList;

public class Leaf extends Component {

    private String name;
    private double weight;

    //CONSTRUCTOR OVERLOADING => More flexibility!
    // We have two constructors, one that takes a name and a weight, and one that only takes a name!

    //-------------------------------------------------------------------------------------------------
    //But we don't care about the weight of a leaf, so we don't need to set it in the constructor.
    Leaf(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    //-------------------------------------------------------------------------------------------------
    //This constructor allows the creation of a Leaf object with just the name, without specifying the weight.
    Leaf(String name) {
        this.name = name;
    }

    //-------------------------------------------------------------------------------------------------
    //toString() is implemented in both Leaf and Composite, and returns a string representation of the object.
    @Override
    public String toString() {
        return this.name;    }

    //-------------------------------------------------------------------------------------------------
    // Since a leaf cannot contain other components, we return false.
    @Override
    public boolean hasChildren() {
        return false;
    }

    //-------------------------------------------------------------------------------------------------
    // Since a leaf cannot contain other components, we return null.
    @Override
    public ArrayList<Component> getChildren() {
        return null;
    }


}
