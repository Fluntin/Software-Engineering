package Human;

//-------------------------------------------------------------------------------------------------
// One of the subclasses of Human.
//-------------------------------------------------------------------------------------------------
class Man extends Human {
    private String name;
    private String pnr;

    Man(String name, String pnr) {
        this.name = name;
        this.pnr = pnr;
    }
    //-------------------------------------------------------------------------------------------------
    // We need to override the toString() method in order to get the correct output.
    //-------------------------------------------------------------------------------------------------
    @Override
    public String toString() {
        return "I am a man and my name is " + this.name;
    }
}