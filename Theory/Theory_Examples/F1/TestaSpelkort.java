class TestaSpelkort {
  public static void main (String[] arg) {
    String[] farger =
      {"Hjarter", "Spader", "Ruter", "Klover"};
    Spelkort[] kortlek = new Spelkort[52];

    int kortnr = 0;
    for (String farg : farger)
      for (int valor = 1; valor<=13; valor++)
        kortlek[kortnr++] =
          new Spelkort(farg, valor);
    for (Spelkort spk : kortlek)
      System.out.println(spk);
  }
}
