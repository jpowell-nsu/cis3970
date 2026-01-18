package driver;

import java.util.ArrayList;

import vehicles.Car;

public class Driver {
	
	public static void main(String[] args) throws CloneNotSupportedException {
		Car car1 = new Car("Toyota", "Corolla", 2020, "Blue", 100);
		Car car2 = new Car("Honda", "Civic", 2019, "Red", 200);
		Car car3 = new Car("Ford", "Mustang", 2021, "Black", 300);
		Car car4 = new Car("Chevrolet", "Camaro", 2022, "Yellow", 400);
		Car car5 = new Car("Tesla", "Model 3", 2023, "White", 500);
		
		Car cloned = (Car) car1.clone();
		
		System.out.println(System.identityHashCode(car1));
		System.out.println(System.identityHashCode(car1.getVinObject()));
		System.out.println(cloned);
		System.out.println(System.identityHashCode(cloned));
		System.out.println(System.identityHashCode(cloned.getVinObject()));
		
		ArrayList<Car> cars = new ArrayList<>();
		cars.add(car5);
		cars.add(car3);
		cars.add(car1);
		cars.add(car2);
		cars.add(car4);
		
		for (Car car : cars) {
			cloned = (Car) car.clone();
			System.out.printf("car=%10s, vin=%10s clone=%10s, clonevin=%10s\n",
					System.identityHashCode(car),
					System.identityHashCode(car.getVinObject()),
					System.identityHashCode(cloned),
					System.identityHashCode(cloned.getVinObject()));
		}
		System.out.println("----------------");
		
		ArrayList<Car> clonedcars;
		clonedcars = (ArrayList<Car>) cars.clone();
		for (Car car : clonedcars) {
			System.out.printf("car=%10s, vin=%10s\n",
					System.identityHashCode(car),
					System.identityHashCode(car.getVinObject()));
		}

	}

}
