import Composite.*;
public class Run {

    public static void main(String[] args) {

        Composite suitcase = new Composite("suitcase", 100);

        Composite hygieneBag = new Composite("hygiene bag", 15);
        Composite sportBag = new Composite("sport bag", 20);
        Composite electronicsBag = new Composite("electronics bag", 10);

        // Items in hygiene bag
        Leaf toothbrush = new Leaf("toothbrush", 1);
        Leaf toothpaste = new Leaf("toothpaste", 2);
        Leaf soap = new Leaf("soap", 1);
        Leaf towel = new Leaf("towel", 5);
        Leaf shampoo = new Leaf("shampoo", 3);
        Leaf conditioner = new Leaf("conditioner", 3);

        // Items in sport bag
        Leaf shoes = new Leaf("shoes", 15);
        Leaf hat = new Leaf("hat", 4);
        Leaf tShirt = new Leaf("t-shirt", 5);
        Leaf shorts = new Leaf("shorts", 4);

        // Items in electronics bag
        Leaf headphones = new Leaf("headphones", 7);
        Leaf laptop = new Leaf("laptop", 10);
        Leaf charger = new Leaf("charger", 2);
        Leaf mouse = new Leaf("mouse", 1);

        // Adding items to hygiene bag
        hygieneBag.addChild(toothbrush);
        hygieneBag.addChild(toothpaste);
        hygieneBag.addChild(soap);
        hygieneBag.addChild(towel);
        hygieneBag.addChild(shampoo);
        hygieneBag.addChild(conditioner);

        // Adding items to sport bag
        sportBag.addChild(shoes);
        sportBag.addChild(hat);
        sportBag.addChild(tShirt);
        sportBag.addChild(shorts);

        // Adding items to electronics bag
        electronicsBag.addChild(headphones);
        electronicsBag.addChild(laptop);
        electronicsBag.addChild(charger);
        electronicsBag.addChild(mouse);

        // Packing bags in suitcase
        suitcase.addChild(hygieneBag);
        suitcase.addChild(sportBag);
        suitcase.addChild(electronicsBag);

        // Printing the entire suitcase
        System.out.println(suitcase);
        System.out.println("Total Weight: " + suitcase.getWeight());
    }
}


