package singleton;

public class SingleObject {
	
	/* you may see something like this in older code, old examples, and even
	 * 	frameworks and legacy code. It does "double-check and locking"
	 * 	however the JVM can actually reorder things and expose a partially
	 * 	constructed object (see the additional notes in the lecture module)
	 */
	
	// volatile is needed to handle threading issues among multiple CPUs
	private static volatile SingleObject instance = new SingleObject();

	private SingleObject() {}
	
	/* Honestly, I still have a hard time imagining why it would
	 * 	ever be done this way. The further past reference I found was
	 *	that it does not work before Java 5. I think it must have been
	 *	a change in Java optimization and memory management
	 */
	public static SingleObject getInstance() {
		if (instance == null) {					// the first check without locking
			synchronized (SingleObject.class) {	// locks it down
				if (instance == null) {			// second check
					instance = new SingleObject();
				}
			}
		}
		return instance;
	}
	
	public void showMessage() {
		System.out.println("Something, something, something, dark side.");
	}

}
