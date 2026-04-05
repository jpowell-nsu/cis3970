package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import characters.Pokemon;

public class Client {
	
	private Socket conn;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	private String addr;
	private int port;
	
	public Client(String addr, int port) {
		this.addr = addr;
		this.port = port;
	}
	
	public void run() {
		String message;
		Integer value;
		Pokemon pokemon;

		try {
			conn = new Socket(addr, port);
			System.out.println("Connected to server");

			oos = new ObjectOutputStream(conn.getOutputStream());
			ois = new ObjectInputStream(conn.getInputStream());
			
			message = "Something, something, something";
			oos.writeObject(message);
			
			message = (String) ois.readObject();
			System.out.println("From Server: " + message);
			
			value = 21;
			oos.writeObject(value);
			
			value = (Integer) ois.readObject();
			System.out.println("From Server: " + value);
			
			pokemon = new Pokemon("Pikachu", "Electric", 25);
			oos.writeObject(pokemon);
						
			ois.close();
			oos.close();
			conn.close();
			
		} catch (IOException e) {
			System.err.println(e);
		} catch (ClassNotFoundException e) {
			System.err.println(e);
		}
	}
	
	
	
}
