package alertsystem;

import factories.NotificationFactory;
import factories.NotificationFactoryProvider;
import users.User;

public class AlertService {
	
	public void sendAlert(User user, Alert alert) {
		NotificationFactory factory = NotificationFactoryProvider.getFactory(user, alert);
		
		factory.notifyUser(alert.getMessage());
	}

}
