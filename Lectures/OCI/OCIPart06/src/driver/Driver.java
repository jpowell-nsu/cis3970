package driver;

import java.util.ArrayList;

import vehicles.Car;

public class Driver {
	
	@SuppressWarnings("unlikely-arg-type")
	public static void main(String[] args) {
		
		// lets take a look at the equals method
		Object o = new Object();
		
		Car car1 = new Car("Toyota", "Corolla", 2020, "Blue");
		Car car2 = new Car("Honda", "Civic", 2019, "Red");
		Car car3 = new Car("Ford", "Mustang", 2021, "Black");
		Car car4 = new Car("Chevrolet", "Camaro", 2022, "Yellow");
		Car car5 = new Car("Tesla", "Model 3", 2023, "White");
		
		Car car6 = new Car("Toyota", "Corolla", 2020, "Blue");
		
		ArrayList<Car> cars = new ArrayList<>();
		cars.add(car5);
		cars.add(car3);
		cars.add(car1);
		cars.add(car2);
		cars.add(car4);
		cars.add(null);
		System.out.println(cars);
		
		if (car1 == car6) {
			System.out.println("1. car1 == car6 is true");
		}
		
		if (car1.equals(car6)) {
			System.out.println("2. car1.equals(car6) is true");
		}

		if (car1.equals(car1)) {
			System.out.println("3. car1.equals(car1) is true");
		}
		
		String temp = "test";
		if (car1.equals(temp)) {
			System.out.println("4. car1.equal(temp) is true");
		}
				
		// why is checking for null important?
		if (car1.equals(cars.get(5))) {
			System.out.println("5. car1 == cars.get(5) is true");
		}
		

	}

}
