package Composite;

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

    @Override
    public double getWeight() {
        return this.weight;
    }

    @Override
    public String toString() {
        return this.name;    }
    
}
