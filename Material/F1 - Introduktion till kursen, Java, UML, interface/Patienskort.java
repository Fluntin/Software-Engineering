class Patienskort extends Spelkort {

   boolean rattvand;

   Patienskort (String f, int v, boolean rv) {
      super(f,v);
      rattvand = rv;
   }
   void vand () {
      rattvand = !rattvand;
   }

    
    public String toString() {
	if (rattvand)
	    return super.toString();
	else
	    return "BAKSIDA";
    }
}
