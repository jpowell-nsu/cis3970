package driver;

import java.util.ArrayList;
import java.util.Collections;

import vehicles.Car;

public class Driver {
	
	public static void main(String[] args) throws CloneNotSupportedException {
		Car car1 = new Car("Toyota", "Corolla", 2020, "Blue", 100);
		Car car2 = new Car("Honda", "Civic", 2019, "Red", 200);
		Car car3 = new Car("Ford", "Mustang", 2021, "Black", 300);
		Car car4 = new Car("Chevrolet", "Camaro", 2022, "Yellow", 400);
		Car car5 = new Car("Tesla", "Model 3", 2023, "White", 500);
		Car car6 = new Car("Ford", "F-150", 2024, "Black", 450);
		Car car7 = new Car("Ford", "Mustang", 2021, "Black", 250);
		
		ArrayList<Car> cars = new ArrayList<>();
		cars.add(car5);
		cars.add(car3);
		cars.add(car1);
		cars.add(car2);
		cars.add(car4);
		cars.add(car6);
		cars.add(car7);
		//cars.add(null);
		
		System.out.println(car5.compareTo(car3));
		System.out.println(car3.compareTo(car5));
		System.out.println(car5.compareTo(null));
		
		System.out.println(cars);
		cars.sort(null);
		//Collections.sort(cars);
		System.out.println(cars);
	}

}
