class A{
    int medlem;

    A(int medlem){
	this.medlem = medlem;
    }

    public boolean equals(Object other){
	System.out.println("Equal i klassen A har anropats!");
	if (other == this )
	    return true;
	else if (((A)other).medlem == this.medlem)
	    return true;
	else
	    return false;
    }
    
}


class Main{
    public static void main(String[] args){
	A a1 = new A(12);
	Object a2 = new A(12);
	
	System.out.println(a1.equals(a2));

    }

}
