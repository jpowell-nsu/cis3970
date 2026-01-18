package factories;

import notifications.EmailNotification;
import notifications.Notification;

public class EmailNotificationFactory extends NotificationFactory {

	@Override
	public Notification createNotification() {
		return new EmailNotification();
	}

}
