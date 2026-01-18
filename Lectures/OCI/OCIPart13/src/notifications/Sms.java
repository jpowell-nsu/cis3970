package notifications;

// concrete product SMS notification
public class Sms implements Notification {

	@Override
	public void send(String message) {
		 System.out.println("Sending SMS: " + message);
	}

}
