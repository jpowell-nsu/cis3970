package creators;

import products.Product;
import products.ConcreteProduct;

public class ConcreteCreator extends Creator {

	@Override
	public Product FactoryMethod() {
		// this is returning an "anonymous object"
		return new ConcreteProduct();
	}

}
