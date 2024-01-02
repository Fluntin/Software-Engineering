class Car{
    
    private Person owner;
    private Color color;
    private String brand;

    Car(String brand, Color color){...}

    public void changeGear(int to){...}
    public void fillPetrol(int literPetrol){...}

    public void repairEngine(){...}
    
}

class Driver extends Person{
    private Car car;
    private String typeOfLicense; 
    Driver (Car car){...}
}

class CarMechanic extends Person{
    private List cars;
    CarMechanic(){...}
    void addCarToRepaire(Car car){}
}











//Båda klasserna Driver och CarMechanic kan anropa repairEngine men man vill inte att Driver ska kunna göra det, då gör vi som nedan:

interface ForDriver{
    public void changeGear(int to);
    public void fillPetrol(int literPetrol);
}

interface ForMechanic{
    public void repairEngine(Car car);
}


class Driver extends Person implements ForDrive{
    private Car car;
    private String typeOfLicense; 
    Driver (Car car){...}
    public void changeGear(int to){...}
    public void fillPetrol(int literPetrol){...}
    
}

class CarMechanic extends Person implements ForMechanic, ForDriver{
    private List cars;
    CarMechanic(){...}
    void addCarToRepaire(Car car){...}
    public void repairEngine(Car car){...}
    public void changeGear(int to){...}
    public void fillPetrol(int literPetrol){...}
}
