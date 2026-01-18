package creators;

import products.Notification;
import products.PushNotification;

public class PushNotificationFactory extends NotificationFactory {

	@Override
	public Notification createNotification() {
		return new PushNotification();
	}

}
