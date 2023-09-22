class Sellable extends Decorator {

    protected int price;
    protected int numberSold;

    public Sellable( LibraryItem libraryItem, int price ) {
	super( libraryItem ) ;
	this.price = price;
    }

    public void sellItem() {
	setNumCopies(getNumCopies()-1);
	numberSold++;
    }


    public void display() {
	libraryItem.display();
	System.out.println(" # Sold: " + numberSold);
	System.out.println(" Price: " + price + " Euro");
    }
}
