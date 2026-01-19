package factories;

import notifications.Notification;

public abstract class NotificationFactory {
	
	// factory method
	protected abstract Notification createNotification();
	
	// business logic that uses the product (this is the point of this application)
	public final void notifyUser(String message) {
		Notification notification = createNotification();
		
		audit(message);
		notification.send(message);
		log(notification);
	}
	
	private void audit(String message) {
		// business logic to review the message, check it, whatever
		System.out.println("Auditing message: " + message);
	}
	
	private void log(Notification notification) {
		// business logic to log that the message was sent
		System.out.println("Notification sent via "
				+ notification.getClass().getSimpleName());
	}

}
