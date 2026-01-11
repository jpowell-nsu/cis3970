package vehicles;

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

}
