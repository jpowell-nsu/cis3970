package creators;

import products.Notification;

public abstract class NotificationFactory {
	
	// factory method
	public abstract Notification createNotification();
	
	// business logic that uses the product (this is the point of this application)
	public void notifyUser(String message) {
		Notification notification = createNotification();
		notification.send(message);
	}

}
