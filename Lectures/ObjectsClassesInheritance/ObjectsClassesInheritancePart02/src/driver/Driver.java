package driver;

import animals.Animal;
import animals.Cat;
import animals.Dog;

public class Driver {

	public static void main(String[] args) {
		Animal dog = new Dog();
		Animal cat = new Cat();
		Cat cat2;
		Dog dog2;
		Animal animal;
		
		// Compile-Time vs. runtime polymorphism 
		// Compile-time - the compiler resolves method calls
		// Runtime - the compiler resolves method calls while executing
		
		// You may ask yourself, doesn't the compiler still do that here?
		dog.makeSound();
		cat.makeSound();
		
		System.out.println("--------");
		//cat2 = dog; 		// not allowed
		//cat2 = (Cat) dog;	// allowed?
		//cat2.makeSound();
		
		//dog2 = cat;			// not allowed
		//dog2 = (Dog) cat;	// allowed?
		//dog2.makeSound();
		
		cat2 = (Cat) cat; // the cat, but I have to cast it
		dog2 = (Dog) dog; // the dog, but I have to cast it
		
		System.out.println("--------");
		if (Math.random() > 0.5) {
			animal = new Dog();
		} else {
			animal = new Cat();
		}
		System.out.println(animal);
		animal.makeSound();
	}

}
