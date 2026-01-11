package driver;

import animals.Animal;
import animals.Cat;
import animals.Dog;

public class Driver {

	public static void main(String[] args) {
		Animal dog = new Dog();
		Animal cat = new Cat();
		//Cat cat2;
		//Dog dog2;
		Animal animal;
		
		System.out.println(dog);
		System.out.println(cat);
		
		System.out.println("--------");
		//cat2 = dog; 		// not allowed
		//cat2 = (Cat) dog;	// allowed?
		//System.out.println(cat2);
		
		//dog2 = cat;		// not allowed
		//dog2 = (Dog) cat;	// allowed?
		//System.out.println(dog2);
		
		//cat2 = (Cat) cat; // the cat, but I have to cast it
		//dog2 = (Dog) dog; // the dog, but I have to cast it
		
		System.out.println("--------");
		if (Math.random() > 0.5) {
			animal = new Dog();
		} else {
			animal = new Cat();
		}
		System.out.println(animal);
	}

}
