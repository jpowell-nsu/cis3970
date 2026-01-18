package products;

// concrete product push notification
public class PushNotification implements Notification {

	@Override
	public void send(String message) {
		System.out.printf("%-36s %-5s: %s%n", this, "PUSH" , message);
	}

}
