package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	private ServerSocket server;
	private Socket client;
	private int port;
	
	public Server(int port) {
		this.port = port;
	}
	
	public void run() {
		try {
			server = new ServerSocket(port);
			
			System.out.println("Server started.");
			System.out.println("Server Info: " + server.getLocalSocketAddress());
			System.out.println("Waiting for client");
		
			while (true) {
				client = server.accept();
				Thread t = new Thread(new Handler(client));
				t.start();
			}
		} catch (IOException e) {
			System.err.println(e);
		} 
	}
	
}
