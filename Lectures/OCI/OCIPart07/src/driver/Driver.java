package driver;

import java.util.ArrayList;

import vehicles.Car;

public class Driver {
	
	public static void main(String[] args) {
		Car car1 = new Car("Toyota", "Corolla", 2020, "Blue");
		Car car2 = new Car("Honda", "Civic", 2019, "Red");
		Car car3 = new Car("Ford", "Mustang", 2021, "Black");
		Car car4 = new Car("Chevrolet", "Camaro", 2022, "Yellow");
		Car car5 = new Car("Tesla", "Model 3", 2023, "White");
		
		Car carSearch = new Car("Toyota", "Corolla", 2020, "Blue");
		
		ArrayList<Car> cars = new ArrayList<>();
		cars.add(car5);
		cars.add(car3);
		cars.add(car1);
		cars.add(car2);
		cars.add(car4);
		cars.add(null);
		System.out.println(cars);
		
		System.out.println(cars.contains(carSearch));
		System.out.println(cars.indexOf(carSearch));
		System.out.println(cars.lastIndexOf(carSearch));

		cars.remove(carSearch);

		System.out.println(cars);
		
		System.out.println(cars.contains(carSearch));
		System.out.println(cars.indexOf(carSearch));
		System.out.println(cars.lastIndexOf(carSearch));
	}

}
