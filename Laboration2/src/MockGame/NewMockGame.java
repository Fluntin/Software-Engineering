package MockGame;

class NewMockGame implements Boardgame {
    private String currentMessage = "This is a MockGame";
    private String[][] board = new String[4][4];
  
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
