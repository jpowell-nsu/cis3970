package application;

import factories.EmailNotificationFactory;
import factories.NotificationFactory;
import factories.PushNotificationFactory;
import factories.SmsNotificationFactory;

public class Driver {
	
	public static void main(String[] args) throws CloneNotSupportedException {
		
		// 1. define your product interface
		//		Notification
		// 2. define concrete products implementing the interface
		//		EmailNotification
		//		PushNotification
		//		SmsNotification
		// 3. define the abstract factory and factory method (the creator)
		//		NotificationFactory
		// 4. define the concrete product factories
		//		EmailNotificationFactory
		//		PushNotificationFactory
		//		SmsNotificationFactory
		// 5. use them in the code
		//		Driver
		
		// now you can add more product types without affecting:
		//		Notification
		//		NotificationFactory
		//		ExistingFactories
		//		business logic for the product--it is in the factory
		//		The application (Driver) may need to be adjusted by having new factories
		
		// why this is good
		//		creation logic is centralized
		//		business logic (notify user) does not have to change
		//		adding new products (notification types) does not break behavior
		//		the superclass (Notification Factory) controls when objects are created
		//		subclasses (various factories) control which objects are created

		NotificationFactory factory;

		factory = new EmailNotificationFactory();
		factory.notifyUser("Welcome!");
		factory.notifyUser("Good morning");

		factory = new SmsNotificationFactory();
		factory.notifyUser("Your code is 1234.");
		factory.notifyUser("New login detected.");
		factory.notifyUser("Your car warranty is expiring. Click here to renew it.");

		factory = new PushNotificationFactory();
		factory.notifyUser("You have a new message.");
	}

}
