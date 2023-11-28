package Extra;

import java.util.Iterator;

public class RunExtra {

    public static void main(String[] args) {

        Composite suitcase = new Composite("suitcase", 100);

        Composite toiletryBag = new Composite("Toiletry Bag", 10);
        Composite plasticBag = new Composite("Plastic Bag", 1);
        Composite shoesBag = new Composite("Shoes Bag", 10);
        Composite electronicsBag = new Composite("Electronics Bag", 20);

        // Items in Toiletry Bag
        Leaf bodyWash = new Leaf("body wash", 2);
        Leaf shampoo = new Leaf("shampoo", 3);
        Leaf razor = new Leaf("razor", 1);
        Leaf shavingCream = new Leaf("shaving cream", 1);

        // Items in Plastic Bag
        Leaf toothbrush = new Leaf("toothbrush", 1);
        Leaf paradontax = new Leaf("paradontax", 1);

        // Items in Shoes Bag
        Leaf shoes = new Leaf("shoes", 15);

        // Items in Electronics Bag
        Leaf laptop = new Leaf("laptop", 10);
        Leaf charger = new Leaf("charger", 2);

        // Rest of the items in Suitcase
        Leaf shirt = new Leaf("shirt", 5);
        Leaf pants = new Leaf("pants", 5);
        Leaf underwear = new Leaf("underwear", 1);
        Leaf socks = new Leaf("socks", 1);

        // Adding items to Plastic Bag
        plasticBag.addChild(toothbrush);
        plasticBag.addChild(paradontax);

        // Adding items to Toiletry Bag
        toiletryBag.addChild(bodyWash);
        toiletryBag.addChild(shampoo);
        toiletryBag.addChild(plasticBag);
        toiletryBag.addChild(razor);
        toiletryBag.addChild(shavingCream);

        // Adding items to Shoes Bag
        shoesBag.addChild(shoes);

        // Adding items to Electronics Bag
        electronicsBag.addChild(laptop);
        electronicsBag.addChild(charger);

        // Adding items to Suitcase
        suitcase.addChild(toiletryBag);
        suitcase.addChild(shoesBag);
        suitcase.addChild(shirt);
        suitcase.addChild(pants);
        suitcase.addChild(underwear);
        suitcase.addChild(socks);
        suitcase.addChild(electronicsBag);

        //System.out.println(suitcase);

        for (Iterator<Component> i = suitcase.iterator(); i.hasNext();) {
            Component item = i.next();
            System.out.println(item);
        }

        
    }
}
