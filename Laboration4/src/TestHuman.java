import Human.*;

public class TestHuman {

    public static void main(String[] args) {

        //-------------------------------------------------------------------------------------------------
        // This is copy-pasta from the instructions.
        Human billie = Human.create("Billie", "xxxxxx-560x");
        Human anna = Human.create("Anna", "xxxxxx-642x");
        Human magnus = Human.create("Magnus","xxxxxx-011x");

        //-------------------------------------------------------------------------------------------------
        // Try to create instances of Man and NonBinary directly, which should result in compilation errors?

        // We attempt to create instances of Man and NonBinary directly using new Man(...) and new NonBinary(...), respectively.
        // This will cause compilation errors, since the constructors are private!

        //  UNCOMMENT THE FOLLOWING LINES TO SEE THE COMPILATION ERRORS!
        // Man john = new Man("John", "xxxxxx-123x"); // Compilation error
        // NonBinary magnus = new NonBinary("Alex", "xxxxxx-789x"); // Compilation error

        // Here we can observe that this will cause a compilation error, since the constructor is private.
        // Human human = new Human("John", "xxxxxx-123x"); // Compilation error
        //-------------------------------------------------------------------------------------------------

        System.out.println(billie);
        System.out.println(anna);
        System.out.println(magnus);
    }
}
