package factories;

import alertsystem.Alert;
import users.User;

public class NotificationFactoryProvider {
	
	// this allows the application not to know about specific types of factories
	// it determines which type of factory, pending on the user and alert

	public static NotificationFactory getFactory(User user, Alert alert) {
		if (alert.isCritical()) {
			return new SmsFactory();
		}
		
		switch (user.getPreferredChannel()) {
			case EMAIL:	return new EmailFactory();
			case SMS:	return new SmsFactory();
        	case PUSH:	return new PushFactory();
        	default: 	throw new IllegalStateException("No notification channel");
		}
	}
}
