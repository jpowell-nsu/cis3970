package interfaces;

public interface Bottom extends Left, Right {

	public static int value = 42;
	
	public static void methodStatic() {
		System.out.println("methodStatic in BOTTOM");
	}
	
	public void methodSomething();

	@Override
	default void methodDefault() {
		methodPrivate();
		
		Left.super.methodDefault();
		Right.super.methodDefault();
		//Top.super.methodDefault();
		//Top.super.super.methodDefault();
		//Left.super.Top.super.

	}

	private void methodPrivate() {
		System.out.println("methodPrivate in BOTTOM");
	}


}
