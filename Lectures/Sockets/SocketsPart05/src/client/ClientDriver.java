package client;

public class ClientDriver {

	public static void main(String[] args) {
		Client client = new Client(2, "192.168.0.16", 4242);
		client.run();
	}

}
