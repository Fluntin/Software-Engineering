abstract class LibraryItem {

    private int numCopies;

    public int getNumCopies () {
	return numCopies;
    }

    public void setNumCopies (int v) {
	numCopies = v;
    }

    public abstract void display();
}
