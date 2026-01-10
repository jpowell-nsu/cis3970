package interfaces;

public class Something implements Bottom {

	@Override
	public void methodSomething() {
		System.out.println("Something method");
	}
	
	@Override
	public void methodDefault() {
		Bottom.super.methodDefault();
		//Left.super.
		//Bottom.super.Left.super
	}

}
