package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import javax.net.ssl.SSLSocket;

public class Handler implements Runnable {
	
	private int connectionCnt;
	private int total;
	private DataInputStream dis;
	private DataOutputStream dos;
	private SSLSocket conn;
	
	public Handler(SSLSocket conn, int clientcnt, int total) {
		this.conn = conn;
		this.connectionCnt = clientcnt;
		this.total = total;
		try {
			dos = new DataOutputStream(this.conn.getOutputStream());
			dis = new DataInputStream(this.conn.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		try {
			int clientID = dis.readInt();
			int amount = dis.readInt();
			connectionCnt++;
			for (int i = 0; i < amount; i++) {
				total += dis.readInt();
			}
			dos.writeUTF("You are client #" + clientID + ", connection #" + connectionCnt + ", current total=" + total);
		} catch (IOException e) {
			e.printStackTrace();
		}


	}


}
