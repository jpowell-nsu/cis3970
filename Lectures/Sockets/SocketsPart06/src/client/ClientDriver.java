package client;

public class ClientDriver {

	public static void main(String[] args) {
		Client client = new Client(1, "localhost", 4242);
		client.run();
	}

}
