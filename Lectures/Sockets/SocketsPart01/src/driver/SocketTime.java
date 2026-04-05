package driver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketTime {
	
	public static void main(String[] args) {
		String host = "dict.org";
		int port = 2628;
		
		try {
			Socket socket = new Socket(host, port);
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(socket.getInputStream())
			);
			PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
			
			System.out.println("Server:" + reader.readLine());
            
			String word = "example";
			writer.println("DEFINE * " + word);
			System.out.println("\nResponse:");
            
			String definition = reader.readLine(); // 250 = OK, end of response
			while (!definition.startsWith("250")) {	
                System.out.println(definition);
                definition = reader.readLine();
            }
			
			socket.close();
			
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}		
	}
}
