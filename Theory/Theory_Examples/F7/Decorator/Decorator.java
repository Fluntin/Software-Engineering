abstract class Decorator extends LibraryItem {

    protected LibraryItem libraryItem;


    public Decorator ( LibraryItem libraryItem ) {
	this.libraryItem = libraryItem;
    }

    public int getNumCopies() {
	return libraryItem.getNumCopies();
    }

    public void setNumCopies(int c) {
	libraryItem.setNumCopies(c);
    }
}
