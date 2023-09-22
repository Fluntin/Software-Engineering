import java.util.*;

class Borrowable extends Decorator {

    protected ArrayList<String> borrowers = new ArrayList<String>();


    public Borrowable( LibraryItem libraryItem ) {
	super( libraryItem ) ;
    }

    public void borrowItem( String name ) {
	borrowers.add( name );
	setNumCopies(getNumCopies()-1);
    }

    public void returnItem( String name ) {
	borrowers.remove( name );
	setNumCopies(getNumCopies()+1);
    }

    public void display() {
	libraryItem.display();
	for (String borrower:borrowers)
	    System.out.println( " borrower: " + borrower );
    }
}
