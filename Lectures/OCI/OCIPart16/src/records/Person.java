package records;

import java.util.Objects;

public record Person(String name, int age, Coordinate location) {
	
	/* this is essentially the compact constructor you are given
	 * 	but the fields are final and initialize, so you cannot
	 * 	do it like this.
	 */
	/*
	public Person {
		this.name = name;
		this.age = age;
		this.location = location;
	}
	*/
	
	// you can do some with your own compact constructor
	//	this one is just doing a check that this.name and this.age is not null
	/*
	public Person {
		Objects.requireNonNull(name);
		Objects.requireNonNull(age);
		Objects.requireNonNull(location);
	}
	*/
	
	// you can overload constructors
	/*
	public Person(String name) { this(name, 0, null); }
	*/
	
	// and you can have your own methods
	/*
	public void something() {
		System.out.println();
	};
	*/
	
	/*
	@Override
	public int age() {
		return -1;
	}
	*/
	
	// you can have static variables and methods
/*
	public static int UNKNOWN_AGE = -1;
	
	public static Person unnamed() {
		return new Person("unamed", UNKNOWN_AGE, null);
	}
*/
	
	/* you can override toString too!
	@Override
	public String toString() {
		return "test";
	}
	*/

}
