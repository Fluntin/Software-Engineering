interface MyInterface{
    int a=12;
    int enMetod();
    default int enAnnanMetod(){	System.out.println(123);
	return 0;
    }
}


class test{

   
    public static void main(String args[]){
	MyInterface mi1=new MyInterface(){
		public void met(){
		    int m=10;
		} 
		public int enMetod(){
		    //this.a=10;
		    return 0;
		}
	    };
	//{public void m(){a=12;}};
	//MyInterface mi2=new MyInterface(){};
	//	mi1.a=12;
	//	System.out.println(mi2.a);
	
    }

}
