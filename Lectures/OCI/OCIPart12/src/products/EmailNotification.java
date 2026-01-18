package products;

// concrete product email notification
public class EmailNotification implements Notification {

	@Override
	public void send(String message) {
		System.out.printf("%-36s %-5s: %s%n", this, "EMAIL" , message);
	}

}
