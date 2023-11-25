package Human;

public abstract class Human {

    Human() {

    }

    public static Human create(String name, String pnr) {
        int lastDigit = Integer.parseInt(pnr.substring(pnr.length()-2,pnr.length()-1));
        if (lastDigit % 2 == 0 && lastDigit != 0) {
            return new Woman(name, pnr);
        }
        else if (lastDigit % 2 != 0) {
            return new Man(name, pnr);
        }
        else if (lastDigit == 0) {
            return new NonBinary(name, pnr);
        }

        return null;
    }

}
