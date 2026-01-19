package products;

// our products are different types of notifications
// but all notifications must have a send method
// thus, the send method is unique to the product type
public interface Notification {

	void send(String message);
	
}
