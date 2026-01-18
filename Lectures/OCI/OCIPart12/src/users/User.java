package users;

import factories.NotificationChannel;

public class User {
	
	private NotificationChannel preferredChannel;
	
	public User(NotificationChannel preferredChannel) {
		this.preferredChannel = preferredChannel;
	}
	
	public NotificationChannel getPreferredChannel() {
		return preferredChannel;
	}
}
