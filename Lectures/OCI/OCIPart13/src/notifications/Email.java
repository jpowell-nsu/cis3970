package notifications;

// concrete product email notification
public class Email implements Notification {

	@Override
	public void send(String message) {
		 System.out.println("Sending EMAIL: " + message);
	}

}
