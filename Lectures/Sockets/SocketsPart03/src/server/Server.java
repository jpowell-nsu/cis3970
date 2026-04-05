package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import characters.Pokemon;

public class Server {
	
	private ServerSocket server;
	private Socket client;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	private int port;
	
	public Server(int port) {
		this.port = port;
	}
	
	public void run() {
		String message;
		Integer value;
		Pokemon pokemon;
		
		try {
			server = new ServerSocket(port);
			
			System.out.println("Server started.");
			System.out.println("Server Info: " + server.getLocalSocketAddress());
			System.out.println("Waiting for client");
		
			client = server.accept();
			oos = new ObjectOutputStream(client.getOutputStream());
			ois = new ObjectInputStream(client.getInputStream());
		
			message = (String) ois.readObject();
			System.out.println("From Client: " + message);
					
			message = "Dark Side";
			oos.writeObject(message);
			
			value = (Integer) ois.readObject();
			System.out.println("From Client: " + value);
			
			value = value*2;
			oos.writeObject(value);
			
			pokemon = (Pokemon) ois.readObject();
			System.out.println(pokemon);
			
			ois.close();
			oos.close();
			client.close();
			server.close();
			
		} catch (IOException e) {
			System.err.println(e);
		} catch (ClassNotFoundException e) {
			System.err.println(e);
		}
	}
	
}
