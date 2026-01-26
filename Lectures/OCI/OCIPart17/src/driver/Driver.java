package driver;

public class Driver {
	
	public static void main(String[] args) {
		/* anonymous classes are one-time-use classes
		 * you define and instantiate it at the same time
		 * and you do not save the reference (technically you can
		 * but that kind of defeats the purpose)
		
		 * some common uses that you may have seen before
		 *	Runnable for threading
		 *	Listeners for GUI programming
		 *	Extending classes for small customizations
		 *		(like overriding a method just for that one instance
		 *	Callbacks and hooks (threading, async APIs, and framework extension points)
		 *	default and mock behavior for testing purposes
		 *	accessing effectively-final local variables
		 *		this is an interesting one you should look up: you capture the local
		 *		variable from the method enclosing the anonymous class and it guarantees
		 *		it will be part of the object, which can live on after the method exists,
		 *		and makes it effectively final
		 *	when lambdas do not work, we'll see lambdas in another lecture 
		 */
		
		Greeter greeter = new Greeter() {
			@Override
			public void greet() {
				System.out.println("Shall we play a game?");
			}
		};
		greeter.greet();
		
		new Greeter() {
			@Override
			public void greet() {
				System.out.println("This has no class.");
			}
		}.greet();
		
		System.out.println(new Greeter() {
			@Override
			public void greet() {
				System.out.println("This has no class.");
			}
		});
		
		int value = 5;
		int another = 10;
	/*	
		System.out.println(new Function() {
			@Override
			public int f() {
				return value*value + 3*value - 3;
			}
		}.f());
		*/
		/*
		System.out.println(new Function() {
			@Override
			public int f(int x) {
				return value*value + 3*value - 3 + x;
			}
		}.f(another));
		 */
		/*
		// notice we cannot use value outside the anonymous class now
		value++;
		another++;
		*/
		
		int y = 10;
		System.out.println(new Function() {
			@Override
			public int f() {
				return y*y + 3*y - 3;
			}
		});

		/* of course, these examples are overkill...
		 * 	the main point is that we can instantiate objects as one-shot things
		 *	and avoid having to create classes and hierarchies for highly
		 *	customized objects that we do not need to reuse
		 *
		 *	they are heavily used with... lambda expressions...
		 */
	}

}
