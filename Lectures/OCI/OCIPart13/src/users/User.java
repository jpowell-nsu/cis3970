package users;

import notifications.Channel;

public class User {
	
	private Channel preferredChannel;
	
	public User(Channel preferredChannel) {
		this.preferredChannel = preferredChannel;
	}
	
	public Channel getPreferredChannel() {
		return preferredChannel;
	}
}
