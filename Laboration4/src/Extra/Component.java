package Extra;

import java.util.ArrayList;

public abstract class Component {

    public abstract String toString();
    public abstract boolean hasChildren();
    public abstract ArrayList<Component> getChildren();
}
