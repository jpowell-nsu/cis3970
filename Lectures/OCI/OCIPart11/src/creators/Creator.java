package creators;

import products.Product;

public abstract class Creator {

	public abstract Product FactoryMethod();
	
	// business logic that uses the product (this is the point of this application)
	public void AnOperation(String message) {
		Product product = FactoryMethod();
		product.display(message);
	}

}
