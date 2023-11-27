package Human;

// One of the subclasses of Human.
class NonBinary extends Human {
    private String name;
    private String pnr;

    NonBinary(String name, String pnr) {
        this.name = name;
        this.pnr = pnr;
    }

    // We need to override the toString() method in order to get the correct output.
    @Override
    public String toString() {
        return "I am non-binary and my name is " + this.name;
    }
}
