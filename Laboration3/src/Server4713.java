/*******************************************
OBS! No swedish letters in this program.
STEN, SAX and PASE is played.
STEN = ROCK, SAX = SCISSORS, PASE = PAPER
*******************************************/
// The Server4713 class is the server that handles the game logic.
// Here it is resposible for generating a random hand and sending it to the client.
import java.net.*;
import java.io.*;
import java.util.*;
public class Server4713 {
    public static void main( String[] args) {
	try {
	    ServerSocket sock = new ServerSocket(4713,100);
	    while (true) 
		new ClientHandler(sock.accept()).start();
	}
	catch(IOException e)
	    {System.err.println(e);
	}
    }
} 

class ClientHandler extends Thread {

    static int numberOfPls=0;
    BufferedReader in;
    PrintWriter out;

    public ClientHandler(Socket socket){
	try {
	    in = new BufferedReader(new InputStreamReader
				    (socket.getInputStream()));
	    out= new PrintWriter(socket.getOutputStream());
		}
		catch(IOException e) {System.err.println(e);
		}
    }
    
    public void run() {
	Random random=new Random();
	String[] hand={"STEN","SAX","PASE"};
	try {
	    String name=in.readLine();
	    System.out.println((++numberOfPls)+": "+name);
            out.println("Hello, "+name);
            out.flush();
		// Here the server is waiting for input from the client.
		// If the client enters blank input, the connection is closed.
		// Otherwise the server sends a random hand to the client.
	    while(true) {
		String input = in.readLine();
		if(input==null || input.equals("")) break;
		out.println(hand[random.nextInt(3)]);
		out.flush();
	    }
	    out.println("Bye " + name); out.flush();
	    System.out.println(name + " stopped playing");
	    numberOfPls--;
	}
        catch(Exception e) {
	    System.err.println(e);
	}
    }
}
/*******************************************
This class serves as the server for the game.
It listens on port 4713 for incoming client connections.
When a client connects, it creates a new ClientHandler thread to handle that client's communication.
It generates a random hand ("STEN," "SAX," or "PASE") for the client to play against.
*******************************************/