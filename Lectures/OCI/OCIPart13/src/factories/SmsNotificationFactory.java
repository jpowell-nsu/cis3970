package factories;

import notifications.Notification;
import notifications.SmsNotification;

public class SmsNotificationFactory extends NotificationFactory {

	@Override
	public Notification createNotification() {
		return new SmsNotification();
	}

}
