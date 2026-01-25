package records;

import java.util.Objects;

public record Person(String name, int a) {
	
	/* this is essentially the compact constructor you are given
	 * 	but the fields are final and initialize, so you cannot
	 * 	do it like this.
	 */
	/*
	public Person {
		this.name = name;
		this.a = a;
	}
	*/
	
	// you can do some with your own compact constructor
	//	this one is just doing a check that this.name and this.a is not null
	/*
	public Person {
		Objects.requireNonNull(name);
		Objects.requireNonNull(a);
	}
	*/
	
	// you can overload constructors
	/*
	public Person(String name) { this(name, 0); }
	*/
	
	// and you can have your own methods
	/*
	public void something() {
		System.out.println();
	};
	*/
	
	// you can have static variables and methods
	/*
	public static int UNKNOWN_AGE = -1;
	
	public static Person unnamed() {
		return new Person("unamed", UNKNOWN_AGE);
	}
	*/
	
	/* you can override toString too!
	@Override
	public String toString() {
		return "test";
	}
	*/

}
