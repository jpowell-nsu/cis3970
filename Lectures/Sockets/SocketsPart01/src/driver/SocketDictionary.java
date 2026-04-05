package driver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class SocketDictionary {
	
	public static void main(String[] args) {
		String host = "time.nist.gov";
		int port = 13;	// well-know port for Daytime protocol
		
		try {
			Socket socket = new Socket(host, port);
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(socket.getInputStream())
			);
			
			String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            
			socket.close();
			
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}		
	}
}
