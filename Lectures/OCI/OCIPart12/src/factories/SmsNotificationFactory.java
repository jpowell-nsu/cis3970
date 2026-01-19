package factories;

import products.Notification;
import products.SmsNotification;

public class SmsNotificationFactory extends NotificationFactory {

	@Override
	public Notification createNotification() {
		return new SmsNotification();
	}

}
