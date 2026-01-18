package vehicles;

public class Car implements Cloneable, Comparable<Car> {
	
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
		return String.format("%n  Car{%d, %-9s, %-7s, %d, %-7s}", VIN.vin, make, model, year, color);
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
	public Car clone() throws CloneNotSupportedException {
		// deep copy
		Car cloned = (Car) super.clone();
		if(cloned.VIN != null) {
			cloned.VIN = new Vin(this.VIN.vin);
		}
		
		return cloned;
	}


	@Override
	public int compareTo(Car o) {

		if (o == null || this.VIN.vin > o.VIN.vin) {
			return 1;
		} else if (this.VIN.vin < o.VIN.vin) {
			return -1;
		} else {
			return 0;
		}
/*
		if (o != null) {
			return this.VIN.vin-o.VIN.vin;
		}
		return 1;
*/
	}

	/*
	@Override
	public int compareTo(Car o) {
		if (o != null) {
			int compareMake = this.make.compareTo(o.make);
			if (compareMake != 0) {
				return compareMake;
			}
			int compareModel = this.model.compareTo(o.model);
			if (compareModel != 0) {
				return compareModel;
			}
			return this.VIN.vin - o.VIN.vin;
		}
		return 1;
	}
*/
}
