class Audiobook extends LibraryItem {

    private String voice;
    private String title;
    private int playTime; // minutes


    public Audiobook( String voice, String title,
		  int numCopies, int playTime ) {
	this.voice = voice;
	this.title = title;
	setNumCopies (numCopies);
	this.playTime = playTime;
    }

    public void display() {
	System.out.println( "\nAudiobook ----- " );
	System.out.println( " Voice: " + voice );
	System.out.println( " Title: " + title );
	System.out.println( " # Copies: " + getNumCopies() );
	System.out.println( " Playtime: "+ playTime );
    }
}
