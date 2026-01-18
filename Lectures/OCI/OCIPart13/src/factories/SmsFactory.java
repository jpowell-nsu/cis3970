package factories;

import notifications.Notification;
import notifications.Sms;

public class SmsFactory extends NotificationFactory {

	@Override
	public Notification createNotification() {
		return new Sms();
	}

}
