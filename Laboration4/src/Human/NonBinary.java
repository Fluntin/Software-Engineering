package Human;

class NonBinary extends Human {
    private String name;
    private String pnr;

    NonBinary(String name, String pnr) {
        this.name = name;
        this.pnr = pnr;
    }

    @Override
    public String toString() {
        return "I am non-binary and my name is " + this.name;
    }
}
