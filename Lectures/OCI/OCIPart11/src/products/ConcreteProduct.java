package products;

public class ConcreteProduct implements Product {

	@Override
	public void display(String message) {
		 System.out.println("Concrete Product: " + message + " " + this);
	}

}
