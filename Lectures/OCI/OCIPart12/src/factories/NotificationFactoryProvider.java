package factories;

import alertsystem.Alert;
import users.User;

public class NotificationFactoryProvider {

	public static NotificationFactory getFactory(User user, Alert alert) {
		if (alert.isCritical()) {
			return new SmsNotificationFactory();
		}
		
		switch (user.getPreferredChannel()) {
			case EMAIL:	return new EmailNotificationFactory();
			case SMS:	return new SmsNotificationFactory();
        	case PUSH:	return new PushNotificationFactory();
        	default: 	throw new IllegalStateException("No notification channel");
		}
	}
}
