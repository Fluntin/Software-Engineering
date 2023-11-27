package Extra;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;


public class Composite extends Component implements Iterable {

    private String name;
    private double weight;
    private ArrayList<Component> children = new ArrayList<Component>();
    private String content;

    Composite(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    Composite(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public void addChild(Component child) {
        children.add(child);
    }

    public void removeChild(Component child) {
        children.remove(child);
    }

    @Override
    public ArrayList<Component> getChildren() {
        return children;
    }

    @Override
    public boolean hasChildren() {
        return children.size() > 0;
    }
    //------------------------------------------------------------------------------------------
    // This is my implementation of the iterator pattern.
    // It uses a breadth-first traversal approach.
    // The iterator() method in the Composite class creates an iterator for breadth-first traversal.
    // It uses a queue (LinkedList) to keep track of the nodes at each level.
    // When next() is called, it pops an element from the queue and adds its children to the queue.
    // This is repeated until the queue is empty.
    //------------------------------------------------------------------------------------------
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
    //------------------------------------------------------------------------------------------
    // This is my implementation of the iterator pattern.
    // It uses a depth-first traversal approach.
    // The deepIterator() method creates an iterator for pre-order traversal.
    // It uses a stack (LinkedList) to traverse the tree depth-first.
    // When next() is called, it pops an element from the stack and pushes its children onto the 
    // stack in reverse order.
    //------------------------------------------------------------------------------------------
    public Iterator deepIterator() {
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

}

