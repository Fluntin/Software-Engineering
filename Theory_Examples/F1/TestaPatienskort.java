class TestaPatienskort {
  public static void main (String[] arg) {
    String[] farger =
      {"Hjarter", "Spader", "Ruter", "Klover"};

    Patienskort[] kortlek = new Patienskort[52];

    int kortnr = 0;
    for (String farg : farger)
      for (int valor = 1; valor<=13; valor++)
        kortlek[kortnr++] =
          new Patienskort(farg, valor, true);

    for (Patienskort pk : kortlek)
      System.out.println(pk);
  }
}
