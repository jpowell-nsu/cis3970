package products;

// our products are different types of notifications
// but all notifications must have a send method
public interface Notification {

	void send(String message);
	
}
