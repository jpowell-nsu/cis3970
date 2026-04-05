package driver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;

public class HttpsTime {
	
	public static void main(String[] args) { 
		try {
			// the URL constructor is deprecated
			//URL url = new URL("https://timeapi.io/api/Time/current/zone?timeZone=UTC");
            
			URI uri = new URI("https://timeapi.io/api/Time/current/zone?timeZone=UTC");
			URL url = uri.toURL();
            
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(url.openStream())
			);

			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
	
			reader.close();
			
		} catch (Exception e) {
			// err is "standard" output stream as designated by the environment
			// it is to the display console by default
			System.err.println("Error: " + e.getMessage());
		}		
	}
}
