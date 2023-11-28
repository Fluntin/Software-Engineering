package Human;
//-------------------------------------------------------------------------------------------------
// One of the subclasses of Human.
//-------------------------------------------------------------------------------------------------
class Woman extends Human {
    private String name;
    private String pnr;

    Woman(String name, String pnr) {
        this.name = name;
        this.pnr = pnr;
    }
    //-------------------------------------------------------------------------------------------------
    // We need to override the toString() method in order to get the correct output.
    //-------------------------------------------------------------------------------------------------
    @Override
    public String toString() {
        return "I am a woman and my name is " + this.name;
    }
}