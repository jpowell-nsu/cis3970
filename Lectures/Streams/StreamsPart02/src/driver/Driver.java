package driver;

import java.util.Arrays;
import java.util.List;

public class Driver {
	
	public static void main(String[] args) {
		/*	Transformations on a stream
		 * 		Operation	Input -> Output		Purpose
				map			1 -> 1				transform each element
				filter		1 -> 0 or 1			keep or disregard elements
				flatMap		1 -> many			expand elements into multiple
		 */
		List<String> words = List.of("apple", "banana", "cherry", "date");
		
		words.stream()
	    	.map(String::toUpperCase)
	    	.forEach(System.out::println);
		
		words.stream()
	    	.filter(w -> w.length() > 5)
	    	.forEach(System.out::println);
		
		// flatMap:
		// 	-each elements becomes multiple elements, but flattened into one stream
		//	-here, each letter becomes an element in the resulting stream
		//	-e.g., [a, p, p, l, e, b, a, ...] from [apple, banana, ...]
		
		// 	-chars() returns an IntStream, which is a primitive stream instead of an object stream
		//	-InStream, DoubleStream, LongStream 
		// 	-mapToObject converts a primitive to the wrapper class object
		// 	-flatMap requires an object stream
		words.stream()
			.flatMap(word -> word.chars().mapToObj(c -> (char) c))
			.forEach(x -> System.out.print(x + " "));
		System.out.println();
		
		List<String> sentences = List.of(
			"hello world",
			"java streams are powerful"
		);
		
		// with map, each string is split, but the values are stored in an array
		// i.e., Stream<String[]> is the type of stream returned
		sentences.stream()
			.map(s -> s.split(" "))
			.forEach(x -> System.out.print(Arrays.toString(x) + " "));
		System.out.println();
		
		// with flatMap, each is split, but the results are stored in one single array
		// i.e., Stream<String> is the type of stream returned
		// it is a little complicated because Arrays.stream is needed to create a Stream<String>
		// for each element first. Then the flapMap puts them together.
		sentences.stream()
			.flatMap(s -> Arrays.stream(s.split(" ")))
			.forEach(x -> System.out.print(x + " "));
		System.out.println();
		
		words.stream()
			.filter(w -> w.length() > 5)   				// keep longer words
			.map(String::toUpperCase)     				// transform them to upper case
			.flatMap(w -> Arrays.stream(w.split(""))) 	// split into letters
			.forEach(x -> System.out.print(x + " "));				// output each
		System.out.println();
		System.out.println();
		System.out.println();
		
		words = List.of(
			"apple", "banana", "cherry", "date", "elderberry", "fig", "grape",
			"honeydew", "kiwi", "lemon", "mango", "nectarine", "orange",
			"papaya", "quince", "raspberry", "strawberry", "tangerine",
			"watermelon", "blueberry", "blackberry", "pineapple", "coconut",
			"apricot", "plum", "pomegranate", "guava", "lychee", "dragonfruit",
			"passionfruit", "persimmon", "boysenberry", "cranberry",
			"grapefruit", "kumquat", "mulberry", "starfruit", "jackfruit",
			"durian", "longan", "rambutan", "currant", "gooseberry",
			"cantaloupe", "huckleberry", "bloodorange", "clementine"
		);
		
		// we can also use peek() to see it in progress
		words.stream()
			.filter(w -> w.length() > 8)
			.peek(w -> System.out.println("After filter: " + w))
			.map(String::toUpperCase)
			.peek(w -> System.out.println("After map: " + w))
			.flatMap(w -> Arrays.stream(w.split("")))
			.forEach(c -> System.out.print(c + " "));

	}
}
