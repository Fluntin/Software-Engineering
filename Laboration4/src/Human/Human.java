package Human;

//This is an abstract class named Human, which means you cannot create instances of it directly.
//It has a constructor with no parameters (a default constructor).
//The constructor is protected, which means that only subclasses can call it.

public abstract class Human {

    Human() {

    }

    // Static factory method that takes a name and a pnr and returns a Human object.
    // The method is static, which means that you can call it without having to create an instance of the class.
    // The method is public, which means that you can call it from anywhere.
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
