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

	//-------------------------------------------------------------------------------------------------
	//This try will try to create a new ServerSocket on port 4713.
	//If it fails, it will catch the exception and print it.
	//-------------------------------------------------------------------------------------------------
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

//-------------------------------------------------------------------------------------------------
// This class is responsible for handling the communication with the client.
// It extends the Thread class to be able to run in a separate thread.
//-------------------------------------------------------------------------------------------------
class ClientHandler extends Thread {

    static int numberOfPls=0;
    BufferedReader in;
    PrintWriter out;

    public ClientHandler(Socket socket){

	//-------------------------------------------------------------------------------------------------
	// This try will try to create a new BufferedReader and PrintWriter.
	// The main purpose of these is to be able to communicate with the client.
	// If it fails, it will catch the exception and print it.
	//-------------------------------------------------------------------------------------------------
	try {
	    in = new BufferedReader(new InputStreamReader
				    (socket.getInputStream()));
	    out= new PrintWriter(socket.getOutputStream());
		}
		catch(IOException e) {System.err.println(e);
		}
    }
    
	//-------------------------------------------------------------------------------------------------
	// This method is called when the thread is started.
	// It will read the name of the player from the client and print it.
	// Then it will send a greeting to the client.
	// Then it will wait for input from the client.
	// If the client enters blank input, the connection is closed.
	// Otherwise the server sends a random hand to the client.
	//-------------------------------------------------------------------------------------------------
    public void run() {
	Random random=new Random();
	String[] hand={"STEN","SAX","PASE"};
	try {
	    String name=in.readLine();
	    System.out.println((++numberOfPls)+": "+name);
            out.println("Hello, "+name);
            out.flush();
		//-------------------------------------------------------------------------------------------------
		// Here the server is waiting for input from the client.
		// If the client enters blank input, the connection is closed.
		// Otherwise the server sends a random hand to the client.
		//-------------------------------------------------------------------------------------------------
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