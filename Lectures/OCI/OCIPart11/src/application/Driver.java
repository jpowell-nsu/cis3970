package application;

import creators.ConcreteCreator;
import creators.Creator;

public class Driver {
	
	public static void main(String[] args) throws CloneNotSupportedException {
		Creator factory;

		// the application code has no idea of what type of product it is using
		factory = new ConcreteCreator();
		factory.AnOperation("Something,");
		factory.AnOperation("Something,");
		factory.AnOperation("Something,");
		factory.AnOperation("Dark Side.");
		
		// four products were created, used, no one knows the details of how,
		// and the products were disposed of by the garbage collector after
	}

}
