package driver;

import singleton.SingleObject;

public class Driver {
	
	public static void main(String[] args) {
		SingleObject controller1 = SingleObject.INSTANCE;
		SingleObject controller2 = SingleObject.INSTANCE;
		
		System.out.println(controller1 == controller2);

		controller1.showMessage();
		controller2.showMessage();
	}

}
