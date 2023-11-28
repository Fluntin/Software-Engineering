package Composite;

//This is an abstract class that serves as the base class for both Composite and Leaf classes.
//It has two abstract methods: getWeight() and toString().

public abstract class Component {

    //-------------------------------------------------------------------------------------------------
    //getWeight() is implemented in Leaf, and returns the weight of the leaf.
    protected abstract double getWeight();

    //-------------------------------------------------------------------------------------------------
    //toString() is implemented in both Leaf and Composite, and returns a string representation of the object.
    //The reason for this is that the toString() method in Composite needs to call the toString() method in its children,
    //and since the children can be either Leaf or Composite, we need to have a toString() method in both classes!
    public abstract String toString();

}
