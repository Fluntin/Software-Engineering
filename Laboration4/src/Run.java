import Composite.*;

public class Run {

    public static void main(String[] args) {

        Composite suitcase = new Composite("suitcase", 100);
        Composite bag = new Composite("torba", 20);
        Composite trunk = new Composite("trunk", 5);
        Composite ness = new Composite("nessiser", 2);

        Leaf laptop = new Leaf("laptop", 10);
        Leaf camera = new Leaf("camera", 40);
        Leaf toothbrush = new Leaf("toothbrush", 50);
        Leaf charger = new Leaf("laptop charger", 12);
        Leaf paper = new Leaf("paper", 17);
        Leaf jumper = new Leaf("rock", 29);
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


        //printing the entire suitcase
        System.out.println(suitcase);
        System.out.println(suitcase.getWeight());


        //removing the hairspray
        System.out.println("Removing the hairspray");
        ness.removeChild(hairspray);

        System.out.println(suitcase);
        System.out.println(suitcase.getWeight());

        //removing the entire trunk
        System.out.println("Removing the trunk");
        bag.removeChild(trunk);

        System.out.println(suitcase);
        System.out.println(suitcase.getWeight());
    }
}
