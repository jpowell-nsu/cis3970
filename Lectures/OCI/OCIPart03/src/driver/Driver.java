package driver;

import interfaces.*;

public class Driver {

	public static void main(String[] args) {
		
		// The Diamond Problem

		Something something = new Something();
		
		Bottom bottom = something;
		Left left = something;
		Right right = something;
		Top top = something;
		
		bottom.methodSomething();
		left.methodSomething();
		right.methodSomething();
		top.methodSomething();		
		
		left.methodDefault();
		right.methodDefault();
		bottom.methodDefault();
		top.methodDefault();

		left = (Left) right;
		right = (Right) left;
		bottom = (Bottom) top;
		

	}

}
