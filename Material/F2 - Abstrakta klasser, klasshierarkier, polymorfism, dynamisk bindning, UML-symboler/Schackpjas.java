import java.awt.*;
class Brade{}
class Ruta{}

abstract class Schackpjas{
    prinvate Color farg;
    Image bild;
    Brade brade;
    private Ruta ruta;

    Schackpjas(Color f, Image bild, Brade b, Ruta r){
	
    }

    abstract boolean dragOk(Ruta r1, Ruta r2);
}


class Bonde extends Schackpjas{
    Bonde(){
	super(Color.black,null,null,null);
    }

    boolean wdragOk(Ruta r1, Ruta r2){
	System.out.println("bonden förflyttar sig");
	return true;}
}

class Dam extends Schackpjas{
    Dam(){
	super(Color.black,null,null,null);
    }

    boolean dragOk(Ruta r1, Ruta r2){return true;}
}

class Torn extends Schackpjas{
    Torn(){
	super(Color.black,null,null,null);
    }
    boolean dragOk(Ruta r1, Ruta r2){return true;}
}

class Springare extends Schackpjas{

    Springare(){
	super(Color.black,null,null,null);
    }
    
    boolean dragOk(Ruta r1, Ruta r2){
	System.out.println("springaren springer");
	return true;
    }
}


abstract class A{
    void method(){
	System.out.println("");
    }
}

class B extends A{

    B(){

    }
}
class C extends A{

    C(){

    }
}

class Main0{
    public static void main(String[] args){
	A a = new B();
	A b = new C();
	Schackpjas s= new Bonde();
	Schackpjas c= new Springare();
	s.dragOk(new Ruta(), new Ruta());
	c.dragOk(new Ruta(), new Ruta());
    }
}
