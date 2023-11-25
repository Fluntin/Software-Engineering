package Human;

class Woman extends Human {
    private String name;
    private String pnr;

    Woman(String name, String pnr) {
        this.name = name;
        this.pnr = pnr;
    }

    @Override
    public String toString() {
        return "I am a woman and my name is " + this.name;
    }
}