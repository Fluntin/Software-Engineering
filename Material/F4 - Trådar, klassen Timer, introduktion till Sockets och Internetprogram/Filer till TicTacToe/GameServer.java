import java.io.*;
import java.net.*;
import java.util.*;

public class GameServer{
    
    public static void main(String[] args) throws Exception{
	ServerSocket serverSckt = new ServerSocket(1234); 
	while(true){
	    TicTocToe game = new TicTocToe();
	    Socket sckt1 = serverSckt.accept();
	    Socket sckt2 = serverSckt.accept();
	    //medan spelet kan fortsätta
	    while(game.isOn()){
		try{
		    //skicka game-objektet till första klienten och ta emot modifierade objektet
		    game = sendRecieve(sckt1,game);
		    //skicka modifierade game-objektet till den andra klienten och ta emot modifierade objektet
		    game = sendRecieve(sckt2,game);
		    //om det inte går att spela längre
		    //skicka game-objektet till första klienten
		    if(!game.isOn())
			send(sckt1,game);
		}catch(GameException ge){
		    game.shutdown();
		    Socket causingSckt = ge.getCausingSocket();
		    if (causingSckt==sckt1)
			send(sckt2,game);
		    else
			send(sckt1,game);
		    break;
		}
	    }
	    sckt1.close();
	    sckt2.close();
	}
    }
    
    private static void send(Socket sckt,TicTocToe game){
	try{
	    ObjectOutputStream objOut = new ObjectOutputStream(sckt.getOutputStream());
	    objOut.writeObject(game);
	    
	}catch(IOException ioe){
	    System.out.println("nagot fel intraffade!"+ ioe);
		
	}
    }
    
    private static TicTocToe sendRecieve(Socket sckt, TicTocToe game)throws GameException{
	try{
	    send(sckt,game);
	    if(game.isOn()){
		ObjectInputStream objIn=new ObjectInputStream(sckt.getInputStream());
		game = (TicTocToe)objIn.readObject();
	    }
	}catch(IOException ioe){
	    System.out.println("nagot IO fel intraffade!"+ ioe);
	    throw new GameException("klient lämnade ", sckt);
	    
	    
	}catch(ClassNotFoundException cnfe){
	    System.out.println("hittar ingen class!"+cnfe);
	}
	
	return game;
    }
}
