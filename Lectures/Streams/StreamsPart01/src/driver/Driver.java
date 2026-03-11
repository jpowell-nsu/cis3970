package driver;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Driver {
	
	public static void main(String[] args) {
		/*	Stream - sequence of elements that supports functional-style
		 * 	operations for data processing
		 *		filtering, transforming, sorting, aggregating 
		 * 	Declarative programming - you describe what you want, not how
		 * 	to do it
		 */
		
		ArrayList<Integer> numbers = new ArrayList<>();
		numbers.add(23);
		numbers.add(45);
		numbers.add(37);
		numbers.add(73);
		numbers.add(42);
		numbers.add(56);
		numbers.add(11);
		numbers.add(89);
		numbers.add(12);
		numbers.add(34);

		for (Integer n : numbers) {
			if (n > 10) {
				System.out.print(n + " ");
			}
		}
		System.out.println();
		
		numbers.stream()
			.filter(n -> n > 10)
			.map(n -> n + " ")
			.forEach(System.out::print);
		System.out.println();
		
		/*	think of it as a pipeline of operations
		 * 		source -> intermediate operations -> terminal operations 
		 */
		
		numbers.stream()					// source
			.filter(n -> n > 10)			// intermediate operation
			.map(n -> n * 2)				// intermediate operation
			.map(n -> n + " ")				// intermediate operation
			.forEach(System.out::print);	// terminal operation
		System.out.println();
		/*	Intermediate operations
		 * 		they return another stream
		 * 		they are lazy - not executed until a terminal operation runs
		 * 	Common:
		 * 		filter		- select elements
		 * 		map 		- transform elements
		 * 		sorted		- sorts elements
		 * 		distinct	- removes duplicates
		 * 		limit		- restrict size
		 */
		List<Integer> result = 
			numbers.stream()
				.filter(n -> n % 2 == 0)
				.map(n -> n * n)
				.sorted()
				.toList();	// terminal to set it up to return a List instead of Stream
		System.out.println(result);
		
		/* Terminal Operations
		 * 		they close (i.e., end) the stream pipeline
		 * 		streams are single-use
		 * Common
		 * 		forEach()	perform action
		 *		collect()	convert to collection
		 *		count()	number of elements
		 *		reduce()	combine values
		 *		findFirst()	return first element
		 */
		
		result = numbers.stream()
					.filter(n -> n > 10)
					.collect(Collectors.toList());
		
		System.out.println(result);
		
		/*	Note: a stream...
		 * 		is not a data structure
		 * 		it does not store elements
		 * 		it processes elements from a source, e.g., collections, arrays, files, generators
		 * 		is single-use
		 */
		
		/* streams can process in parallel (true parallelism?); however... 
		 * 	order may not be preserved
		 *	synchronization issues can occur
		 *	overhead may outweigh benefits for small tasks
		 */
		for (int i = 0; i < 5; i++) {
			numbers.add((int) Math.random()*10000);
		}
		
		numbers.parallelStream()
			.filter(n -> n > 10)
			.map(n -> n * 2)
			.collect(Collectors.toList());
		
		List<Pokemon> pokedex = List.of(
				new Pokemon("Pikachu", "Electric", 25),
				new Pokemon("Charmander", "Fire", 12),
				new Pokemon("Bulbasaur", "Grass", 18),
				new Pokemon("Squirtle", "Water", 10),
				new Pokemon("Gyarados", "Water", 35),
				new Pokemon("Jolteon", "Electric", 28),
				new Pokemon("Vulpix", "Fire", 14)
		);	
		
		// Filter Pokemon by Type
		pokedex.stream()
			.filter(p -> p.type().equals("Fire"))
			.forEach(System.out::println);
		
		// Get Names of High-Level Pokemon
		pokedex.stream()
			.filter(p -> p.level() > 20)
			.map(Pokemon::name)
			.forEach(System.out::println);
	
		// Sort Pokemon by Level
		List<Pokemon> sorted = pokedex.stream()
			.sorted(Comparator.comparing(Pokemon::level))
			.collect(Collectors.toList());
		
		System.out.println(sorted);
		
		// Average Pokemon Level
		double avgLevel = pokedex.stream()
							.mapToInt(Pokemon::level)
							.average()
							.orElse(0);

		System.out.println("Average level: " + avgLevel);
		
		// Count Pokemon by Type
		long waterCount = pokedex.stream()
			    			.filter(p -> p.type().equals("Water"))
			    			.count();

		System.out.println("Water Pokémon: " + waterCount);
	}

}
