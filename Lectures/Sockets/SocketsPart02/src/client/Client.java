package client;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
	
	private Socket conn;
	private DataInputStream in;
	private DataOutputStream out;
	private String addr;
	private int port;
	
	public Client(String addr, int port) {
		this.addr = addr;
		this.port = port;
	}
	
	public void run() {
		String message;
		int value;
		
		try {
			conn = new Socket(addr, port);
			System.out.println("Connected to server");

			in = new DataInputStream(new BufferedInputStream(conn.getInputStream()));
			out = new DataOutputStream(conn.getOutputStream());
			
			message = "Something, something, something";
			out.writeUTF(message);
			
			message = in.readUTF();
			System.out.println("From Server: " + message);
			
			value = 21;
			out.writeInt(value);
			
			value = in.readInt();
			System.out.println("From Server: " + value);
						
			in.close();
			out.close();
			conn.close();
			
		} catch (IOException e) {
			System.err.println(e);
		}
	}
	
	
	
}
