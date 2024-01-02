import java.io.*;

interface GameInterface extends Serializable{

    public boolean update(String sign, int r, int c);
    public boolean isOn();
    public void play();
    public String getWinner();
    public void shutdown();
    
}
