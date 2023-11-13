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
