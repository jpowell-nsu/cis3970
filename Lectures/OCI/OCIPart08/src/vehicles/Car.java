package vehicles;

//import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Car {
	
	private String make;
	private String model;
	private int year;
	private String color;

	public Car(String make, String model, int year, String color) {
		this.setMake(make);
		this.setModel(model);
		this.setYear(year);
		this.setColor(color);
	}

	public String getMake()  { return make; }
	public String getModel() { return model; }	
	public int getYear()     { return year; }	
	public String getColor() { return color; }
	
	public void setMake(String make)   { this.make = make; }
	public void setModel(String model) { this.model = model; }
	public void setYear(int year)      { this.year = year; }
	public void setColor(String color) { this.color = color; }

	@Override
	public String toString() {
		// alternative is to use the StringBuilder class
		return String.format("Car{make='%s', model='%s', year=%d, color='%s'}", make, model, year, color);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) { return true; }
		
		// if (!(obj instanceof Car)) { return false; }
		
		if (obj == null || this.getClass() != obj.getClass()) { return false; }

		Car car = (Car) obj;

		return (car.make.equals(this.make)
				&& car.model.equals(this.model)
				&& car.year == this.year
				&& car.color.equals(this.color));
	}

	@Override
	public int hashCode() {
		// The hashcode() and equals() is suppose to form a contract
		
		// Remember that the default hashCode is the identity of the object
		// The hashCode method that is used in many collections to do matching
		// Two object with the same equality based on our specification can 
		//		end up in different buckets because of the identity
		// So a search on the hash code using the identity will not find
		//		the object that matches our specifics of equality
		// if the hash code is based on equality specifics, not identity,
		//		then logically two objects with the same equality would match
				
		int result = 17;	// start with a prime number and use primes
							// (https://codingtechroom.com/question/why-use-prime-number-in-hashcode)
		/*
		int result = 17;
		result = 31 * result + (make  != null ? make.hashCode()  : 0);	// strings have a proper hashCode
		result = 31 * result + (model != null ? model.hashCode() : 0);	
		result = 31 * result + year;
		result = 31 * result + (color != null ? color.hashCode() : 0);
		 */
		/*
		HashCodeBuilder builder = new HashCodeBuilder();
		builder.append(make);
		builder.append(model);
		builder.append(year);
		builder.append(color);
		result = builder.hashCode();
		 */
		
		return result;
	}
	
}
