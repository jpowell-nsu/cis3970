package creators;

import products.Product;

public abstract class Creator {

	// notice how the abstract Creator does not need to know type of product it will produce
	// because all of our products are implementing "Product"
	public abstract Product FactoryMethod();
	
	// business logic that uses the product (this is the point of this application)
	// notice how the Creator does have to know the product type. It just uses the method
	// that the Product interface guarantees will be defined in the Product
	// the actual application will simply call this method to do the work
	public void AnOperation(String message) {
		Product product = FactoryMethod();
		product.display(message);
	}

}
