package lab8;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class GameClient {
    private final static String SERVER_ADDRESS = "127.0.0.1";
    private final static int PORT = 8100;
    public static void main(String[] args) throws IOException {
        GameClient client = new GameClient();
        try
        {
        	Socket sock = new Socket(SERVER_ADDRESS, PORT);
        	while (true) {
        	   String request = client.readFromKeyboard();
        	   if (request.equalsIgnoreCase("exit"))
        	   {
        	      break;
        	   }
        	   else 
        	   {
        	       client.sendRequestToServer(request, sock);
        	   }
        	}
        	sock.close();
        }
        catch (UnknownHostException e)
        {
        	System.err.println("No server listening... " + e);
        }
        
        
    }
    
    
    private void sendRequestToServer(String request, Socket sock) {
		try {
			PrintWriter out = new PrintWriter(sock.getOutputStream(),true);
			BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			out.println(request);
			out.flush();
			String response = in.readLine();
			System.out.println(response);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
    private String readFromKeyboard() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
        
    }
}
