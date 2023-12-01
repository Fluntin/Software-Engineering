package Extra;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Composite extends Component implements Iterable {

    //------------------------------------------------------------------------------------------
    // This is the Composite class, which extends the Component class.
    // We don't care about the weight of a composite, so we don't need to set it in the constructor.
    private String name;
    private double weight;
    private ArrayList<Component> children = new ArrayList<Component>();
    private String content;

    //CONSTRUCTOR OVERLOADING => More flexibility!
    //We have two constructors, one that takes a name and a weight, and one that only takes a name.

    //------------------------------------------------------------------------------------------
    //The constructor that takes a name and a weight sets the name and the weight of the composite.
    Composite(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    //------------------------------------------------------------------------------------------
    //The constructor that takes a name sets the name of the composite.
    Composite(String name) {
        this.name = name;
    }

    //------------------------------------------------------------------------------------------
    //toString() is implemented in both Leaf and Composite, and returns a string representation of the object.
    @Override
    public String toString() {
        return this.name;
    }

    //------------------------------------------------------------------------------------------
    // Here we need to have a method that adds a child to the composite.
    // Since we defined a list of children in the Composite class, we can use the add() method to add a child to the list.
    public void addChild(Component child) {
        children.add(child);
    }

    //------------------------------------------------------------------------------------------
    //We also need to have a method that removes a child from the composite.
    //Since we defined a list of children in the Composite class, we can use the remove() method to remove a child from the list.   
    public void removeChild(Component child) {
        children.remove(child);
    }

    //------------------------------------------------------------------------------------------
    // We need to override the getChildren() method in the Component class.
    // Since we defined a list of children in the Composite class, we can just return the list of children.
    @Override
    public ArrayList<Component> getChildren() {
        return children;
    }

    //------------------------------------------------------------------------------------------
    // We need to override the hasChildren() method in the Component class.
    // Since we defined a list of children in the Composite class, we can just check if the list of children is empty.
    @Override
    public boolean hasChildren() {
        return children.size() > 0;
    }

    //------------------------------------------------------------------------------------------
    //JUICY PART!
    //------------------------------------------------------------------------------------------

    
    //BREADTH-FIRST TRAVERSAL APPROACH
    //------------------------------------------------------------------------------------------
    // This is my implementation of the iterator pattern.
    // It uses a breadth-first traversal approach.
    // The iterator() method in the Composite class creates an iterator for breadth-first traversal.
    // It uses a queue (LinkedList) to keep track of the nodes at each level.
    // When next() is called, it pops an element from the queue and adds its children to the queue.
    // This is repeated until the queue is empty.
    //------------------------------------------------------------------------------------------
    /**/
    @Override
    public Iterator iterator() {
        LinkedList queue = new LinkedList();

        for (Component child : children) {
            queue.add(child);
        }

        return new Iterator() {
            @Override
            public boolean hasNext() {
                return !queue.isEmpty();
            }

            @Override
            public Object next() {
                Component child = (Component) queue.pop();
                if (child.hasChildren()) {
                    ArrayList<Component> children = child.getChildren();
                    for (Component c : children) {
                        queue.addLast(c);
                    }
                }
            return child;
            }
        };
    }
    
    //DEPTH-FIRST TRAVERSAL APPROACH
    //------------------------------------------------------------------------------------------
    // This is my implementation of the iterator pattern.
    // It uses a depth-first traversal approach.
    // The deepIterator() method creates an iterator for pre-order traversal.
    // It uses a stack (LinkedList) to traverse the tree depth-first.
    // When next() is called, it pops an element from the stack and pushes its children onto the 
    // stack in reverse order.
    //------------------------------------------------------------------------------------------
    /*
    @Override
    public Iterator iterator() {
        LinkedList stack = new LinkedList();

        for (int i=children.size()-1; i>=0; i--) {
            stack.addFirst(children.get(i));
        }

        return new Iterator() {
            @Override
            public boolean hasNext() {
                return !stack.isEmpty();
            }

            @Override
            public Object next() {
                Component child = (Component) stack.pop();
                if (child.hasChildren()) {
                    ArrayList<Component> children = child.getChildren();
                    for (int i=children.size()-1; i>=0; i--) {
                        stack.addFirst(children.get(i));
                    }
                }
                return child;
            }
        };
    } 
*/
}