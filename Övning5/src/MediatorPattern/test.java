package MediatorPattern;

public class test {
    public static void main(String[] args) {
        Mediator mediator = new Mediator();

        User user1 = new ActualUser(mediator, "Theo1");
        User user2 = new ActualUser(mediator, "Theo2");
        User user3 = new ActualUser(mediator, "Theo3");

        mediator.addUser(user1);
        mediator.addUser(user2);
        mediator.addUser(user3);

        user2.sendMessage("Hallå!");
    }
}
