package interfaces;

public interface Top {
	
	public static int value = 42;
	
	public static void methodStatic() {
		System.out.println("methodStatic in TOP");
	}
	
	public void methodSomething();
	
	default public void methodDefault() {
		System.out.println("methodDefault in TOP");
		methodPrivate();
	}
	
	private void methodPrivate() {
		System.out.println("methodPrivate in TOP");
	}

}
