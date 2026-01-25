package singleton;

public class SingleObject {
	
	/* sometimes it is better for the loading to wait	
	 *	the inner static class is not loaded until referenced
	 *	it is not common to have anything else in the inner class
	 * 	Also, by definition, class loading is thread safe
	 *	this way has better performance
	 */
	private static class Single {
		private static final SingleObject instance = new SingleObject();
	}

	private SingleObject() {}
	
	public static SingleObject getInstance() { return Single.instance; }
	
	public void showMessage() {
		System.out.println("Something, something, something, dark side.");
	}

}
