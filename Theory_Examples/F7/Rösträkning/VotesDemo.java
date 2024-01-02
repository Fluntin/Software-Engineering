class VotesDemo {

    public static void main (String[] u) {
	VotesModel mod = new VotesModel();
	VotesInput vi = new VotesInput(mod);
	vi.setLocation(70,70);  // screen position

	// Text image
	TextView tv = new TextView();
	tv.setLocation(350,70);
	mod.addObserver(tv);    // register as Observer

	// Piechart image
	PieView pv = new PieView();
	pv.setLocation(350,400);
	mod.addObserver(pv);

	// Barchart image
	BarView bv = new BarView();
	bv.setLocation(700,200);
	mod.addObserver(bv);

	// To show the inital state
	mod.change();
    }
}