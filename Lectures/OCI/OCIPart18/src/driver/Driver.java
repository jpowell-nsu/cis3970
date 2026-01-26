package driver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Driver {
	
	private void add(int x, int y) {
		System.out.println(x + y);
	}
	
	//(x, y) -> System.out.println(x + y);
	
	public static void main(String[] args) {
		/*	Starting in Java 8 (2014)
		 *  Lambda expressions implement functional interfaces (interface with only one abstract method)
		 * 	It enables passing code as data through method arguments
		 * 	Allows defining behavior without defining a class
		 * 	They can make code shorter and cleaner, reducing boiler plate code
		 *  They are like functional-style programming
		 *  They can simplify APIs that use call backs (you see a lot of this in GUI programming)
		 *  They encourage immutability and thread safety
		 *  	they cannot have instance fields
		 *  	only capture effectively final variables
		 */
		
		//Function f = (x, y) -> { return x + y; };
		Function f = (x, y) -> x + y;
		
		int result = f.operation(21, 21);
		
		System.out.println(result);
		System.out.println(f.operation(0, 42));
		
		f = (x, y) -> x*x + x*y + y*y;
		//f.
		System.out.println(f.operation(1, 2));
		
		f = (x, y) -> { System.out.println(x + y); return x + y; };
		f.operation(37, 73);
		
		// there are several Java provided functional interfaces
		
		// Predicate<T> - Tests a condition and returns true or false ("test something")
		Predicate<Integer> isEven = x -> x % 2 == 0;
		System.out.println(isEven.test(4));
		System.out.println(isEven.test(7));
		
		// Consumer<T> - processes an argument and does not return a value ("do something")
		Consumer<Integer> pacman = ghost -> System.out.println(--ghost);
		pacman.accept(4);
		
		pacman = ghosts -> {for(; ghosts > 0; ghosts--)
								System.out.print(ghosts + " ");
							System.out.println(); };
		pacman.accept(4);
		
		// Supplier - no argument but returns a result "(provide something)"
		Supplier<Integer> ghosts = () -> (int) (Math.random() * 10);
		System.out.println(ghosts.get());
		
		pacman.accept(ghosts.get());
		// pacman.accept(Suppler<Integer> g = () -> (int) (Math.random() * 10));
		
		// Comparator<T> - compares two objects to determine order
		List<String> names = Arrays.asList("Alice", "Bob", "Carol", "Diane", "It");
			
		Collections.sort(names, new Comparator<String>() {
			@Override
			public int compare(String a, String b) {
				return a.length() - b.length();
			}
		});		

		// lets set it up to use a lambda expression...


		System.out.println(names);
		
		// Comparable<T> - compares two objects based on the "natural" ordering
		// you have seen this before in previous lectures!
		//Comparable<String> temp;
		
		ArrayList<Integer> numbers = new ArrayList<Integer>();
	    numbers.add(5);
	    numbers.add(9);
	    numbers.add(8);
	    numbers.add(1);
	    
	    Consumer<Integer> method = (n) -> { System.out.println(n + 5); };
	    numbers.forEach(method);
	    
	    // can we just put the lambda expression directly in forEach?
	    
			
		// but where these are really useful is in streams... (coming soon)
	}

}
