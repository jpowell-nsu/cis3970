package driver;

import java.util.Scanner;

import records.Coordinate;
import records.Person;

public class Driver {
	
	public static void main(String[] args) {
		Coordinate pointA = new Coordinate(1, 2);
		Coordinate pointB = new Coordinate(1, 2);
		
		//pointA.
		System.out.println(pointA);
		System.out.println(pointA.x());
		System.out.println(pointA.y());
		System.out.println(pointA.getClass());
		
		System.out.println(pointA == pointB);
		System.out.println(pointA.equals(pointB));
		
		System.out.println(pointA.hashCode());
		System.out.println(pointB.hashCode());
		// note: there is actually not a guarantee that the hashCode is unique between
		// and two objects! It depends on the data and how we calculate the hash
		
		/* The birthday paradox: the surprising probability 
		 * that in a group of just 23 people, there is over a 50% chance 
		 * that at least two individuals share the same birthday. This 
		 * counter intuitive result arises because the number of possible 
		 * pairs of people increases rapidly as the group size grows, 
		 * leading to many opportunities for shared birthdays.
		 */
		
		Person p1 = new Person("Jason", 42, pointA);
		Person p2 = new Person("Jason", 42, pointB);
		
		System.out.println(p1);
		System.out.println(p2);
		
		System.out.println(p1.equals(p2));
		
		System.out.println(p1.hashCode());
		System.out.println(p2.hashCode());
		
			
		Scanner scnr = new Scanner(System.in);
		System.out.print("Enter name: ");
		String name = scnr.next();
		
		Person p3 = new Person(name, 42, pointA);
		System.out.println(p1.equals(p3));

		scnr.close();
		
	}

}
