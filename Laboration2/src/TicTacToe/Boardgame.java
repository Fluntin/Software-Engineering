package TicTacToe;
public interface Boardgame {
  public boolean move(int i, int j);
  public String getStatus(int i, int j);
  public String getMessage(); 
}
