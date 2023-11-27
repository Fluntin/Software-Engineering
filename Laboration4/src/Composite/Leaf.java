package Composite;

//This class also extends the Component class and represents a leaf component, which cannot contain other components.
//It has a name and a weight.

public class Leaf extends Component {

    private String name;
    private double weight;

    public Leaf(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    public Leaf(String name) {
        this.name = name;
    }

    //The weight is set in the constructor, and is used in the getWeight() method.
    @Override
    public double getWeight() {
        return this.weight;
    }

    //The name is set in the constructor, and is used in the toString() method.
    @Override
    public String toString() {
        return this.name;    }
    
}
