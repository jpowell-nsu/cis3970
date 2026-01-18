package factories;

import notifications.Notification;
import notifications.PushNotification;

public class PushNotificationFactory extends NotificationFactory {

	@Override
	public Notification createNotification() {
		return new PushNotification();
	}

}
