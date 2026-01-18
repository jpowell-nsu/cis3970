package factories;

import notifications.Notification;
import notifications.Push;

public class PushFactory extends NotificationFactory {

	@Override
	public Notification createNotification() {
		return new Push();
	}

}
