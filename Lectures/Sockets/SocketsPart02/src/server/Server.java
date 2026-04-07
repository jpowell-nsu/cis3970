package server;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	private ServerSocket server;
	private Socket client;
	private DataInputStream in;
	private DataOutputStream out;
	private int port;
	
	public Server(int port) {
		this.port = port;
	}
	
	public void run() {
		String message;
		int value;
		try {
			server = new ServerSocket(port);
			System.out.println("Server started.");
			System.out.println("Waiting for client");
		
			client = server.accept();
			in = new DataInputStream(new BufferedInputStream(client.getInputStream()));
			out = new DataOutputStream(client.getOutputStream());
			//in.read
		
			message = in.readUTF();
			System.out.println("From Client: " + message);
					
			message = "Dark Side";
			out.writeUTF(message);
			
			value = in.readInt();
			System.out.println("From Client: " + value);
			
			out.writeInt(value*2);
		
			in.close();
			out.close();
			client.close();
			server.close();
			
		} catch (IOException e) {
			System.err.println(e);
		}
	}
	
}
