package animals;

public class Dog extends Animal {
	
	@Override
	public String toString() {
		//System.out.println(super.toString());
		//return "The dog barks";
		return String.format("%s-%s", super.toString(), "The dog barks");
	}

}
