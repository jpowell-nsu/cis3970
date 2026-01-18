package products;

// concrete product email notification
public class EmailNotification implements Notification {

	@Override
	public void send(String message) {
		 System.out.println("Sending EMAIL: " + message);
	}

}
