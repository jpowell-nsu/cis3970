package server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server {
	
	private DatagramSocket socket;
	private DatagramPacket receivedpacket;
	private DatagramPacket sendpacket; 
	private int port;

	public Server(int port) {
		this.port = port;
	}
	
	public void run() {
		try {
			byte[] out;
			byte[] buffer = new byte[1024];
			String received;
			
			socket = new DatagramSocket(port);
			System.out.println("Server started.");
			System.out.println("Server Info: " + socket.getLocalSocketAddress());
			System.out.println("Waiting for client");

			while (true) {
				receivedpacket = new DatagramPacket(buffer, buffer.length);
				socket.receive(receivedpacket);
				received = new String(receivedpacket.getData(), 0, receivedpacket.getLength(), "UTF-8");
				
				System.out.println("Received from " + receivedpacket.getAddress() + ":" + receivedpacket.getPort() + " -> " + received);
				
				out = ("Echo: " + received).getBytes("UTF-8");
				sendpacket = new DatagramPacket(out, out.length, receivedpacket.getAddress(), receivedpacket.getPort());
				socket.send(sendpacket);
			}
			
			// socket.close();
		} catch (IOException e) {
			System.err.println(e);
		} 
	}
	
}
