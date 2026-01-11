package vehicles;

import org.apache.commons.lang3.builder.EqualsBuilder;

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
		return String.format("%nCar{make='%s', model='%s', year=%d, color='%s'}", make, model, year, color);
	}
	
	//@Override
	public boolean equals(Object obj) {
		if (this == obj) { return true; }
		
		// if (!(obj instanceof Car)) { return false; }
		
		// alternative approach to instanceof		
		// 	instanceof checks the inheritance hierarchy at compile time
		// 	getClass() returns the runtime class
		//		when comparing the results of getClass, it does not check the inheritance hierarchy
		//		this is often the preferred way for equals
		
		if (obj == null || this.getClass() != obj.getClass()) { return false; }

		Car car = (Car) obj;

		// we have to be cautious with comparisons
		/*
		return (car.make.equals(this.make)
				&& car.model.equals(this.model)
				&& car.year == this.year
				&& car.color.equals(this.color));
				*/

		// alternative: use EqualsBuilder from the apache commons library
		EqualsBuilder builder = new EqualsBuilder();
		builder.append(this.make, car.make);
		builder.append(this.model, car.model);
		builder.append(this.color, car.color);
		builder.append(this.year, car.year);
		
		return builder.isEquals();

	}

}
