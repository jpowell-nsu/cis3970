package alertsystem;

import factories.NotificationFactory;
import factories.NotificationFactoryProvider;
import users.User;

public class AlertService {
	
	// notice that the alert service has no idea of the type of factory needed
	public void sendAlert(User user, Alert alert) {
		NotificationFactory factory = NotificationFactoryProvider.getFactory(user, alert);
		
		factory.notifyUser(alert.getMessage());
	}

}
