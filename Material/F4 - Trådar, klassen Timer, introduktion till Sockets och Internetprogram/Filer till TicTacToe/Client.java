import java.net.*; 
import java.io.*;

public class Client{
    public static void main(String[] args){
	GameInterface game=null;
	ObjectOutputStream objOut =null;
	ObjectInputStream objIn=null;
	try{
	    System.out.println("Väntar på annan spelare!");
	    Socket sckt = new Socket("localhost",1234);
	    do{
		objOut = new ObjectOutputStream(sckt.getOutputStream());
		objIn=new ObjectInputStream(sckt.getInputStream());

		game = (GameInterface)objIn.readObject();
		if(game.isOn()){
		    game.play();
		    objOut.writeObject(game);
		}
	    } while(game.isOn());
	    System.out.println("Spelet är slut\n"+game+"\n"+game.getWinner()+ " Vann!");

	}catch(IOException ioe){
	    System.out.println("nagot IO fel intraffade!"+ioe);
	}catch(ClassNotFoundException cnfe){
	    System.out.println("hittar ingen class!"+cnfe);
	}
	
	
    }
}
 
