package MockGame;

class NewMockGame implements Boardgame {
    private String currentMessage = "This is a MockGame";
    private String[][] board = new String[8][8];
  
    public boolean move(int i, int j) {
      return true;
    }
  
    public String getStatus(int i, int j) {
      return "";
    }
  
    public String getMessage() {
      return currentMessage;
    }  
}
