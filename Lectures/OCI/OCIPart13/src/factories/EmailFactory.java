package factories;

import notifications.Email;
import notifications.Notification;

public class EmailFactory extends NotificationFactory {

	@Override
	public Notification createNotification() {
		return new Email();
	}

}
