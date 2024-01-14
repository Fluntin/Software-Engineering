//Följande följer INTE  sammanhållningsprincipen p.g.a
//nameOfDriver i klassen Car
//carColor i klassen Person

class Car{
    
    private String nameOfDriver;
    private String carBrand;
    private Color carColor;
    
    Car(String arBrand){...}

    void changeNameOfDriver(String newName){
	nameOfDriver = newName;
    }    
}


class Person{
    private String carColor;
    private Sting surename;
    Person(String surename){...}

    
}


//Följande följer  sammanhållningsprincipen
// Car har endast en association till Person
// Person har endast en association till Car

class Car{
    
    private Person driver;
    private String carBrand;
    private Color carColor;
    Car(String arBrand){...}
}


class Person{
    private Car car;
    private Sting surename;
    Person(String surename){...}

    void changeName(String newName){
	surename = newName;
    }    
    
}


