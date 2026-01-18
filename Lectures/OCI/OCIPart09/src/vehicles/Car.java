package vehicles;

public class Car implements Cloneable {
	
	private String make;
	private String model;
	private int year;
	private String color;
	private Vin VIN;

	public Car(String make, String model, int year, String color, int vin) {
		this.setMake(make);
		this.setModel(model);
		this.setYear(year);
		this.setColor(color);
		
		this.VIN = new Vin(vin);
	}

	public String getMake()   { return make; }
	public String getModel()  { return model; }	
	public int getYear()      { return year; }	
	public String getColor()  { return color; }
	public int getVin()	 	  { return VIN.getVin(); }
	public Vin getVinObject() { return this.VIN; }
	
	public void setMake(String make)   { this.make = make; }
	public void setModel(String model) { this.model = model; }
	public void setYear(int year)      { this.year = year; }
	public void setColor(String color) { this.color = color; }
	public void setVin(int vin)		   { this.VIN.vin = vin; }
	
	@Override
	public String toString() {
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
		int result = 17;

		result = 31 * result + (make  != null ? make.hashCode()  : 0);	// strings have a proper hashCode
		result = 31 * result + (model != null ? model.hashCode() : 0);	
		result = 31 * result + year;
		result = 31 * result + (color != null ? color.hashCode() : 0);

		return result;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		// note: We must implement Cloneable to get the proper setup for cloning
		 
		// shallow copy
		
		Object cloned = super.clone();
		
		return cloned;
	}
	
	/*
	// Covariant - different return type
	public Car clone() throws CloneNotSupportedException {
		// shallow copy
		Car cloned = (Car) super.clone();
		
		return cloned;
	}
	*/
	
	/*
	// Covariant - different return type
	public Car clone() throws CloneNotSupportedException {
		// deep copy
		Car cloned = (Car) super.clone();
		if(cloned.VIN != null) {
			cloned.VIN = new Vin(this.VIN.vin);
		}
		
		return cloned;
	}
	*/
}
