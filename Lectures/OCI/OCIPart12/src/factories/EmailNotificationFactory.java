package factories;

import products.EmailNotification;
import products.Notification;

public class EmailNotificationFactory extends NotificationFactory {

	@Override
	public Notification createNotification() {
		return new EmailNotification();
	}

}
