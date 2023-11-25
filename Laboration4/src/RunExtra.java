package Extra;

import java.util.Iterator;

public class RunExtra {

    public static void main(String[] args) {
        Composite suitcase = new Composite("suitcase", 100);
        Composite bag = new Composite("bag", 10);
        Composite trunk = new Composite("trunk", 20);
        Composite ness = new Composite("ness", 30);

        Leaf laptop = new Leaf("laptop", 10);
        Leaf camera = new Leaf("camera", 40);
        Leaf toothbrush = new Leaf("toothbrush", 50);
        Leaf charger = new Leaf("charger", 12);
        Leaf paper = new Leaf("paper", 17);
        Leaf jumper = new Leaf("jumper", 29);
        Leaf tshirt = new Leaf("tshirt", 32);
        Leaf hairspray = new Leaf("hairspray", 10);
        Leaf phone = new Leaf("phone", 11);

        //ness has hairspray
        ness.addChild(hairspray);

        //trunk has ness as well as charger, paper and jumper
        trunk.addChild(ness);
        trunk.addChild(charger);
        trunk.addChild(paper);
        trunk.addChild(jumper);



        //bag has trunk as well as camera, toothbrush and laptop
        bag.addChild(laptop);
        bag.addChild(camera);
        bag.addChild(toothbrush);
        bag.addChild(trunk);


        //suitcase has bag as well as tshirt and phone
        suitcase.addChild(bag);
        suitcase.addChild(tshirt);
        suitcase.addChild(phone);


        for (Iterator<Component> i = suitcase.deepIterator(); i.hasNext();) {
            Component item = i.next();
            System.out.println(item);
        }
    }
}
