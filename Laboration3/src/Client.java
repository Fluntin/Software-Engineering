import java.net.*;
import java.io.*;
import java.util.*;

// Set up a client that connects to the server and plays the game.
// On a local machine, the server and client can be run on the same machine.
public class Client {

  public static void main(String[] u) {
    try {
      Socket socket=new Socket("localhost",4713);
      BufferedReader in=new BufferedReader
          (new InputStreamReader(socket.getInputStream()));
      PrintWriter ut=new PrintWriter(socket.getOutputStream());
      // This will be the name of the player.
      ut.println("Player of the year"); ut.flush();
      System.out.println(in.readLine());

      // I want to maintain connection and continuously prompt user for input.
      // If the user enters blank input, the connection should be closed.
      // The server terminates the connection.
      // This is because the server is waiting for input from the client.
      Scanner sc = new Scanner(System.in);
      while (true) {
        String userInput = sc.nextLine();
        System.out.println("Please enter STEN/SAX/PASE: "); // I can't get the swedish letters to work :P
        ut.println(userInput); ut.flush();
        System.out.println(in.readLine());
      }

    } catch (IOException e) {
      System.out.println(e);
    }
  }

}
/*******************************************
This class represents the client-side of the game.
It connects to the server running on "localhost" at port 4713.
It uses a BufferedReader to read input from the server and a PrintWriter to send input to the server.
It continuously prompts the user for input (choices: "STEN," "SAX," or "PASE") using a Scanner.
It sends the user's choice to the server and receives the server's response, printing it to the console.
The client can exit the game by entering blank input.
*******************************************/