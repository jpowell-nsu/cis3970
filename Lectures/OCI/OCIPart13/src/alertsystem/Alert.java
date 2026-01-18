package alertsystem;

public class Alert {
	
	private boolean critical;
	private String message;
	
	public Alert(boolean isCritical, String message) {
		this.critical = isCritical;
		this.message = message;
	}

	public boolean isCritical() { return critical; }
	public String getMessage()  { return message; }
	
}
