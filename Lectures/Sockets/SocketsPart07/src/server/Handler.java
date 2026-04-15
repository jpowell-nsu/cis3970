package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.net.ssl.SSLSocket;

public class Handler implements Runnable {
	
	private int connectionCnt;
	private ArrayList<Integer> values;
	private DataInputStream dis;
	private DataOutputStream dos;
	private SSLSocket conn;
	
	public Handler(SSLSocket conn, int clientcnt, ArrayList<Integer> values) {
		this.conn = conn;
		this.connectionCnt = clientcnt;
		this.values = values;
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
			
			int temp = connectionCnt;
			temp = temp + 1;
			connectionCnt = temp;
			
			int amount = dis.readInt();
			int total = 0;
			for (int i = 0; i < amount; i++) {
				int value = dis.readInt();
				values.add(value);
				total += value;
			}
				
			dos.writeUTF("You are client #" + clientID + ", connection #" + connectionCnt + ", current total=" + total);
			
			dos.close();
			dis.close();
			conn.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
