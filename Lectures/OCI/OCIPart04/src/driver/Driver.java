package driver;

import java.util.ArrayList;

import vehicles.Car;

public class Driver {
	
	public static void main(String[] args) {
		int min = 0;
		int max = 10;
		
		ArrayList<Integer> values = new ArrayList<>();
	
		for (int i = 0; i < 10; i++) {
			values.add(min + (int) (Math.random() * (max - min + 1)));
		}
		
		System.out.println(values);
		System.out.println(values.contains(5));
		System.out.println(values.indexOf(5));
		System.out.println(values.lastIndexOf(5));
		values.sort(null);
		System.out.println(values);
		System.out.println(values.remove(new Integer(5)));
		System.out.println(values);
		
		// lets take a look at the toString method
		Object obj;
		//obj.
		
		obj = new Object();
		System.out.println(obj);
		System.out.println(obj.toString());
		
		Car car1 = new Car("Toyota", "Corolla", 2020, "Blue");
		Car car2 = new Car("Honda", "Civic", 2019, "Red");
		Car car3 = new Car("Ford", "Mustang", 2021, "Black");
		Car car4 = new Car("Chevrolet", "Camaro", 2022, "Yellow");
		Car car5 = new Car("Tesla", "Model 3", 2023, "White");
        
		System.out.println(car1);
        
		ArrayList<Car> cars = new ArrayList<>();
		cars.add(car5);
		cars.add(car3);
		cars.add(car1);
		cars.add(car2);
		cars.add(car4);
		cars.add(null);
		
		System.out.println(cars.get(1));
		
		for (Car car : cars) {
		//	if (car != null) {
				System.out.println(car);
		//		System.out.println(car.toString());
		//	}
		}  
        
		System.out.println(cars);
		
	}

}
