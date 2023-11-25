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

