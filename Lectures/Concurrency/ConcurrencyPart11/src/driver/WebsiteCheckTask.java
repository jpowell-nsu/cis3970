package driver;

import java.net.HttpURLConnection;
import java.net.URI;
import java.util.concurrent.Callable;

public class WebsiteCheckTask implements Callable<String> {
	
	private String website;
	
	public WebsiteCheckTask(String website) {
		this.website = website;
	}

	@Override
	public String call() throws Exception {
		try {
			URI uri = new URI(website);
			HttpURLConnection connection =
					(HttpURLConnection) uri.toURL().openConnection();

			connection.setRequestMethod("GET");
			connection.setConnectTimeout(5000);
			connection.connect();

			int code = connection.getResponseCode();

			return website + " -> HTTP " + code;
		} catch (Exception e) {
			return website + " -> ERROR: " + e.getMessage();
        }
	}

}
