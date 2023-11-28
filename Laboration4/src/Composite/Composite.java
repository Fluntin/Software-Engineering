package Composite;

import java.util.ArrayList;

//This class extends the Component class and represents a composite component, which can contain other components (either Composite or Leaf objects).
//It has a name, a weight, a list of children and a content.
//The content is a string that is used to represent the component in the toString() method.
//The content is set in the constructor, and is used in the toString() method.
//The weight is set in the constructor, and is used in the getWeight() method.
//The name is set in the constructor, and is used in the toString() method.
//The children are added and removed using the addChild() and removeChild() methods.
//The toString() method returns a string representation of the component, which is the name of the component followed by a colon, followed by the content of the component.

public class Composite extends Component {

    //A string representing the name of the composite.
    private String name;
    //A double representing the weight of the composite.
    private double weight;
    //An ArrayList of Component objects representing the children of the composite.
    private ArrayList<Component> children = new ArrayList<Component>();
    //A string representing the content of the composite.
    private String content;

    //CONSTRUCTOR OVERLOADING => More flexibility!
    //We have two constructors, one that takes a name and a weight, and one that only takes a name.

    //-------------------------------------------------------------------------------------------------
    //The constructor that takes a name and a weight sets the name and the weight of the composite.
    public Composite(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    //-------------------------------------------------------------------------------------------------
    //The constructor that takes a name sets the name of the composite.
    Composite(String name) {
        this.name = name;
    }

    //-------------------------------------------------------------------------------------------------
    //The getWeight() method returns the weight of the composite.
    //Calculates the total weight of the composite by summing the weight of the composite itself and the weights of its child components recursively.
    // This shold be easy if we remember recursion!

    @Override
    public double getWeight() {
        double totalWeight = weight;
        for (Component child : children) {
            totalWeight += child.getWeight();
        }
        return totalWeight;
    }
    // Depth-first traversal approach is used to calculate the weight of the composite. 
    // This is faster than the breadth-first traversal approach, since it doesn't have to traverse the entire tree.

    //-------------------------------------------------------------------------------------------------
    // The toString() method returns a string representation of the composite.
    // This shold be easy if we remember recursion!
    @Override
    public String toString() {
         StringBuilder str = new StringBuilder(this.name + ":");
         for (Component child : children) {
             str.append(String.join("", " " + child.toString()));
        } return str.toString();
    }

    //-------------------------------------------------------------------------------------------------
    //The addChild() method adds a child to the composite.
    //The child is added to the children ArrayList.
    public void addChild(Component child) {
        children.add(child);
    }

    //-------------------------------------------------------------------------------------------------
    //The removeChild() method removes a child from the composite.
    //The child is removed from the children ArrayList.
    public void removeChild(Component child) {
        children.remove(child);
    }

}
