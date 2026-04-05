package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {
	
	private Socket conn;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	private int ID;
	private String addr;
	private int port;

	public Client(int ID, String addr, int port) {
		this.ID = ID;
		this.addr = addr;
		this.port = port;
	}
	
	public void run() {
		try {
			conn = new Socket(addr, port);

			oos = new ObjectOutputStream(conn.getOutputStream());
			ois = new ObjectInputStream(conn.getInputStream());
			
			while (true) {
				oos.writeObject(ID);
				
				String message = (String) ois.readObject();
				System.out.println("From server: " + message);
				Thread.sleep(1000);
			}
						
			//ois.close();
			//oos.close();
			//conn.close();
			
		} catch (IOException e) {
			System.err.println(e);
		} catch (ClassNotFoundException e) {
			System.err.println(e);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
	
}
