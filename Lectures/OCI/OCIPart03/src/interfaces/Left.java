package interfaces;

public interface Left extends Top {

	public static int value = 42;
	
	public static void methodStatic() {
		System.out.println("methodStatic in LEFT");
	}
	
	public void methodSomething();
	
	default public void methodDefault() {
		System.out.println("methodDefault in LEFT");
		methodPrivate();
	}
	
	private void methodPrivate() {
		System.out.println("methodPrivate in LEFT");
	}
	
}
