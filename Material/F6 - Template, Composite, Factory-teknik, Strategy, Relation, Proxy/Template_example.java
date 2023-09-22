abstract class Integrator { 
    private double min, max, intervall;
    
    abstract double func(double x);
    
    void set (double min, double max, double intervall){
	this.min=min;
	this.max=max;
	this.intervall=intervall;

    }

    double calcIntegralValue (){
	double sum=0;
	while(min<=max){
	    sum += func(min); //access function
	    min+=intervall;
	}
	return sum;
    }
    
    public static void main(String [] a){
	BellIntegrator bell =new BellIntegrator();
	bell.set(-0.2, 0.7, 0.0001);
	System.out.println(bell.calcIntegralValue());
	bell.set(0, 1, 0.001);
	System.out.println(bell.calcIntegralValue());
	
	
    }
}

class BellIntegrator extends Integrator{ 
    public double func(double x){
	return Math.exp(-11*x*x); 
    }
}
