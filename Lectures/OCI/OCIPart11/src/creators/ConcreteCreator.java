package creators;

import products.Product;
import products.ConcreteProduct;

public class ConcreteCreator extends Creator {

	// this is extending the abstract creator
	// it creates products 
	@Override
	public Product FactoryMethod() {
		// this is returning an "anonymous object" product
		return new ConcreteProduct();
	}

}
