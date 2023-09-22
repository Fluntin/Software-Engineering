class Book extends LibraryItem {

    private String author;
    private String title;

    public Book(String author, String title, int numCopies) {
	this.author = author;
	this.title = title;
	setNumCopies(numCopies);
    }

    public void display() {
	System.out.println( "\nBook ------ " );
	System.out.println( " Author: "+ author );
	System.out.println( " Title: "+ title );
	System.out.println( " # Copies: "+ getNumCopies() );
    }
}
