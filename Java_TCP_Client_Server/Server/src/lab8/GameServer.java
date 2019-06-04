package lab8;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class GameServer {
    private static final int PORT = 8100;
    private static ServerSocket serverSocket;
    private boolean running = false;

    public static void main(String[] args)  throws IOException {
        GameServer server = new GameServer();
        try
        {
        	server.init();
            server.waitForClients();
        }
        catch (IOException e)
        {
        	System.out.println("Communication problems: " + e);
        }
       
    }
    // Implement the init() method: create the serverSocket and set running to true
    // Implement the waitForClients() method: while running is true, create a new socket for every incoming client and start a ClientThread to execute its request.
	
    private void init() throws IOException{
		serverSocket = new ServerSocket(PORT);
		running = true;
	}

	private void waitForClients() {
		try
		{
			while(running)
			{
				System.out.println("Waiting for clients...");
				Socket socket = serverSocket.accept();
				new ClientThread(this,socket).start();
			}
		}
		catch (IOException e)
		{
			System.out.println("I don't know what to write for this error message: " + e);
		}
		
	}

	public void stop() throws IOException {
        this.running = false;
        serverSocket.close();
    }
}