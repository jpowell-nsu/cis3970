package driver;

import java.util.HashMap;

import vehicles.Car;

public class Driver {
	
	public static void main(String[] args) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
		Car car1 = new Car("Toyota", "Corolla", 2020, "Blue");
		Car car2 = new Car("Honda", "Civic", 2019, "Red");
		Car car3 = new Car("Ford", "Mustang", 2021, "Black");
		Car car4 = new Car("Chevrolet", "Camaro", 2022, "Yellow");
		Car car5 = new Car("Tesla", "Model 3", 2023, "White");
		
		//Object o = new Object();
		//System.out.println(o + ", " + o.hashCode());
		
		HashMap<Car, String> garage = new HashMap<>();
		
		// put(key, value);
		garage.put(car5, "Gracelyn");
		garage.put(car3, "Ronnie");
		garage.put(car1, "Annie");
		garage.put(car2, "Thaddeus");
		garage.put(car4, "Luciana");
		garage.put(null, "Lainey");
		
		// WARNING: HashMap does not allow duplicate keys
		//Car carx = new Car("Ford", "Mustang", 2021, "Black");
		//garage.put(carx, "Jason"); 
		
		System.out.println(garage);

		/*
		The initial default capacity of the hash map table is 16 buckets. You use to be able
		to get the current capacity with Java Reflection, but it looks like they disabled
		the accessibility. Let me know if you can get it to work. 
		
		Field tableField = HashMap.class.getDeclaredField("table");
		tableField.setAccessible(true); // fails here now
		Object[] table = (Object[]) tableField.get(garage);
		System.out.println(table == null ? 0 : table.length);
		  
		 */
		int tablesize = 16;
		int hash;
		int bucket;
		String value;
		for (Car car : garage.keySet()) {
			if (car != null) {
				hash = car.hashCode();
				bucket = (hash & (tablesize - 1));			
			} else {
				// null objects go into bucket 0
				bucket = 0;
				hash = 0;
			}
			value = garage.get(car);
			System.out.printf("Bucket %2d | hash=%12d | value=%8s | key=%s\n", bucket, hash, value, car);
		}
		
		// suppose we want to find out who owns a car that matches this information
		Car findCar = new Car("Ford", "Mustang", 2021, "Black");
		System.out.println(findCar.hashCode());
		hash = findCar.hashCode();
		bucket = (hash & (tablesize - 1));
		System.out.println("Bucket: " + bucket);
		
		System.out.println("Owner: " + garage.get(findCar));
	}

}
