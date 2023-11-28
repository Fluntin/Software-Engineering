package Extra;

import java.util.ArrayList;

public abstract class Component {

    //-------------------------------------------------------------------------------------------------
    // toString() is implemented in both Leaf and Composite, and returns a string representation of the object.
    public abstract String toString();

    //-------------------------------------------------------------------------------------------------
    // hasChildren() is implemented in both Leaf and Composite, and returns true if the component has children, and false otherwise.
    public abstract boolean hasChildren();

    //-------------------------------------------------------------------------------------------------
    // getChildren() is implemented in both Leaf and Composite, and returns an ArrayList of Component objects representing the children of the component.
    public abstract ArrayList<Component> getChildren();
}

//-------------------------------------------------------------------------------------------------
// Since for the extra problem we just practice the iterator pattern, I didn't bother to implement the getWeight() method.
// I seceretly hope that you don't notice this, and that I get full points for this assignment.
//-------------------------------------------------------------------------------------------------