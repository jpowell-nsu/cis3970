package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.net.ssl.SSLSocket;

public class Handler implements Runnable {
	
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	private SSLSocket conn;
	
	public Handler(SSLSocket conn) {
		this.conn = conn;
		try {
			oos = new ObjectOutputStream(this.conn.getOutputStream());
			ois = new ObjectInputStream(this.conn.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		Integer clientID;
		try {
			while (true) {
				clientID = (Integer) ois.readObject();
				System.out.println("From Client# " + clientID + " " + conn);
				
				String message = "Recieved.";
				oos.writeObject(message);
			}

			//ois.close();
			//oos.close();
			//conn.close();			
		
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}

	}


}
