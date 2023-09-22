class Spelkort {

    String farg;
    int valor;

  Spelkort (String f, int v) {
    farg = f;   valor = v;
  }


   public String toString () {
      String valorString;
      if (valor == 1)
         valorString = specvalor[0];
      else if (valor >=2 && valor <=10)
         valorString = "" + valor;
      else
         valorString = specvalor[valor - 10];
      return farg + " " + valorString;
   }
    static String[] specvalor
      = {"ESS", "KNEKT", "DAM", "KUNG"};
 
}
