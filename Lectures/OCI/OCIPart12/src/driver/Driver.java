package driver;

import alertsystem.Alert;
import alertsystem.AlertService;
import factories.NotificationChannel;
import users.User;

public class Driver {
	
	public static void main(String[] args) throws CloneNotSupportedException {
		// we offer the customers an alert service
		AlertService alertService = new AlertService();
		
		// here are some of our users
		User user1 = new User(NotificationChannel.EMAIL);
		User user2 = new User(NotificationChannel.PUSH);
		
		// imagine having a client program connects and needs to send an alert
		// and these are some of the alerts received from that client program
		Alert alert1 = new Alert(false, "Your weekly report is read");	// normal alert example
		Alert alert2 = new Alert(true, "Suspicious login detected"); 	// critical alert example
		
		// imagine this is our alert system sending out the alerts to specific clients
		alertService.sendAlert(user1, alert1);
		System.out.println();
        alertService.sendAlert(user2, alert1);
        System.out.println();
        alertService.sendAlert(user1, alert2);
        System.out.println();
        alertService.sendAlert(user2, alert2);
        
        // challenge: Add a new type of notification: SlackNotification
	}

}
