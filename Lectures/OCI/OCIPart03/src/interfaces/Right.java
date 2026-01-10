package interfaces;

public interface Right extends Top {
	
	public static int value = 42;
	
	public static void methodStatic() {
		System.out.println("methodStatic in RIGHT");
	}
	
	public void methodSomething();
	
	default public void methodDefault() {
		System.out.println("methodDefault in RIGHT");
		methodPrivate();
	}
	
	private void methodPrivate() {
		System.out.println("methodPrivate in RIGHT");
	}

}
