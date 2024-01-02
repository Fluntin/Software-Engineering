import java.util.*;
public class DecoratorApp {
    public static void main( String[] args ) {
	Scanner scanner = new Scanner(System.in);

	// Create book and audiobook and display
	Book book = new Book( "Lauri Lebo", "The Devil in Dover", 10 );
	Audiobook audiobook = 
	    new Audiobook( "Stephen Fry",
			   "The Complete Harry Potter Collection", 23, 7500);
	book.display();
	audiobook.display();

	scanner.nextLine();
	// Make book sellable, display, sell, display
	System.out.println("\nBook made sellable, sell one copy");
	Sellable sBook = new Sellable(book, 13);
	sBook.display();
	sBook.sellItem();
	sBook.display();

	scanner.nextLine();
	// Make audiobook borrowable, borrow and display
	System.out.println( "\nAudiobook made borrowable, two borrowers:");
	Borrowable bAudiobook = new Borrowable(audiobook);
	bAudiobook.borrowItem("Petter Al");
	bAudiobook.borrowItem("Elsie Ek");

	bAudiobook.display();

	scanner.nextLine();
	// Make audiobook also sellable, display, sell 3 copies, display again
	System.out.println("\nAudiobook made also sellable, sell 3 copies:");
	Sellable sbAudiobook = new Sellable(bAudiobook, 18);
	sbAudiobook.display();
	sbAudiobook.sellItem(); sbAudiobook.sellItem();
	sbAudiobook.sellItem();
	sbAudiobook.display();
    }
}
