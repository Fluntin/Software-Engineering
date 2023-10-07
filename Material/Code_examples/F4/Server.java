import java.net.*;
import java.io.*;
import java.util.*;
class Server4712{
    public static void main(String[]a){
	try{
	    ServerSocket sock = new ServerSocket(4712,100);
	    while(true){
		new Clienthandler(sock.accept()).start();
		System.out.println("*****");
	    }
	}
	catch(IOException ioe){
	    System.out.println(ioe);
	}
    }
}    


class Clienthandler extends Thread{
    static int antaltradar=0;
    BufferedReader in;
    PrintWriter ut;
    public Clienthandler(Socket socket){
	try{
	    in=new BufferedReader(new InputStreamReader(
						       socket.getInputStream()));
	    ut=new PrintWriter(socket.getOutputStream());
	}
	catch(IOException e){System.err.println(e);}
    }
    
    public void run ( ) {
	Random random=new Random ( ) ;
	String[] hand={"STEN","SAX","PASE"};
	try{
	    //halsningar
	    while(true){
		String indata=in.readLine();
		System.out.println(indata);
		if(indata==null||indata.equals(""))
		    break;
		ut.println(hand[random.nextInt(3)]);
		ut.flush();
	    }
	    //avslutning
	}
	catch(Exception e){
	    System.err.println(e);
	}
    }

}
