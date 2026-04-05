package server;

public class ServerDriver {

	public static void main(String[] args) {
		Server server = new Server(4242);
		server.run();
	}

}
