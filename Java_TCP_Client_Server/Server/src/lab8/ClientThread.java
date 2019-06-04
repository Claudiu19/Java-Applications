package lab8;

import java.io.*;
import java.net.Socket;

public class ClientThread extends Thread {
    private Socket socket = null;
    private final GameServer server;
    public ClientThread(GameServer server, Socket socket)
    {
    	this.server=server;
    	this.socket=socket;
    }
    public void run() throws NullPointerException{
        BufferedReader in;
        String request ="a";
        try
        {
        	while(request!=null)
        	{
        		
        			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        			PrintWriter out = new PrintWriter(socket.getOutputStream()); //server -> client stream
        			request = in.readLine();
        			String response = execute(request);
        			out.println(response);
        			out.flush();
        		
        	}
        }
    	catch (IOException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
		finally
		{
			try
			{
				socket.close();
			}
			catch (IOException e)
			{
				System.err.println("Couldn't close socket: " + e);
			}
		}
    }    
    private String execute(String request) throws NullPointerException{
    	if(request!=null)
    	{
    		System.out.println("Server received the request " + request);
    	}
        return ("Request received: " + request);
    }
	public GameServer getServer() {
		return server;
	}
}
