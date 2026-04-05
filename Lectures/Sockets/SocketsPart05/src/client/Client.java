package client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client {
	private DatagramSocket socket;
	private InetAddress address;
	private DatagramPacket sendpacket;
	private DatagramPacket receivepacket;
	private int ID;
	private String addr;
	private int port;

	public Client(int ID, String addr, int port) {
		this.ID = ID;
		this.addr = addr;
		this.port = port;
	}
	
	public void run() {
		String message = "Hello from client #" + ID;
		String received;
		byte[] out;
		byte[] buffer = new byte[1024];

		long packetcnt = 1;
		
		try {
			socket = new DatagramSocket();
			address = InetAddress.getByName(addr);

			while (true) {
				message = "Client #" + ID + ", Packet #" + packetcnt;
				out = message.getBytes("UTF-8");
				sendpacket = new DatagramPacket(out, out.length, address, port);
				socket.send(sendpacket);
				
				receivepacket = new DatagramPacket(buffer, buffer.length);
				socket.setSoTimeout(3000);		// set a time out
				socket.receive(receivepacket);	// block until reply or timeout
				received = new String(receivepacket.getData(), 0, receivepacket.getLength(), "UTF-8");
				
				System.out.println("Server " + received);
				
				Thread.sleep(1000);
				packetcnt++;
			}
            
            //socket.close();
		} catch (IOException e) {
			System.err.println(e);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
