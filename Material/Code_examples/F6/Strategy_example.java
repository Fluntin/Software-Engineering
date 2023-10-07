interface Func{
    public double func(double x);
}



class Integrator { 
    Func funcObj;
    private double min, max , intervall;
    
    Integrator(Func fuo){
	funcObj = fuo;
    }
    
    void set (double min, double max, double intervall){
	this.min=min;
	this.max=max;
	this.intervall=intervall;

    }
    void setFunc(Func fuo){ //change function
	funcObj = fuo;
    }

    double integralValue (){
	double sum=0;
	while(min<=max){
	    sum += funcObj.func(min); //access function
	    min+=intervall;
	}
	return sum;
    }
    
    public static void main(String [] a){
	Func bell =new Bell();
	Integrator integrator = new Integrator(bell ); 
	integrator.set(-0.2, 0.7, 0.0001);
	System.out.println(integrator.integralValue());
	//Bytfunktionsobjekt
	integrator.setFunc(new ArcSinh());
	integrator.set(0,0.65,0.001);
	System.out.println(integrator.integralValue()) ;
	
	integrator.setFunc(new Func(){ 
		public double func(double x){
		    return (x*x+37)/(1+x ); }
	    });

	integrator.set (-0.9 ,0 ,0.01);
	System.out.println(integrator.integralValue()) ;
    }
}

class Bell implements Func{ 
    public double func(double x){
	return Math.exp(-11*x*x); 
    }
}

class Sin1 implements Func{ 
    public double func(double x){
	return Math.sin(x)/x; 
    }
}

class ArcSinh implements Func{ 
    public double func(double x){
	return Math.log(x+Math.sqrt(x*x+1)); 
    }
}
