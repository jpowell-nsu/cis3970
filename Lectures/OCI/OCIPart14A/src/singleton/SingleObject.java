package singleton;

public class SingleObject {
	
	/* singleton design ensures there is only one instance of an object and provides
	 *	a global point of access. These are often used when you need one controller
	 *	to coordinate actions in a system
	 */
	
	// private static instance: you only need one instance and there should be some protection
	private static SingleObject instance;
	
	// have a private constructor because only this class should be able to create the single instance
	private SingleObject() {
		// you can initialize things if you need to
	}
	
	/* return the instance so other parts of the program can use it
	 * 	you see this in a lot of examples, but it is often considered
	 *	flawed because it is not thread safe. Sometimes you see "synchronized"
	 * 	on it "public static synchronized SingleObject getInstance()," but
	 * 	that is also considered flawed because of performance lost as
	 * 	synchronization takes place upon every call after the instance
	 *	is already created. We'll talk more about threads later this
	 * 	semester. Part B of this lecture tackles how to do this better
	 */
	public static SingleObject getInstance() {
		if (instance == null) {
			instance = new SingleObject();
		}
		
		return instance;
	}
	
	// business logic involving controlling something
	public void showMessage() {
		System.out.println("Something, something, something, dark side.");
	}

}
