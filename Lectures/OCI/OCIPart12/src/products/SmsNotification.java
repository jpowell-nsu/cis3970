package products;

// concrete product SMS notification
public class SmsNotification implements Notification {

	@Override
	public void send(String message) {
		System.out.printf("%-36s %-5s: %s%n", this, "SMS" , message);
	}

}
