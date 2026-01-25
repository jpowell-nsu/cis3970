package singleton;

/* it can even be done as an enum
 *	enum initialization is thread safe
 *	the JVM prevents multiple instances by serialization
 *		(more later this semester about serialization)
 *  the JVM prevents reflection attacks
 *		(https://prgrmmng.com/security-implications-reflection-mitigate-risks-java)

 * enums are very attractive because of the simplicity, but have a lot of limitations
 *	(see additional notes in the lecture module)
 *	for example, you cannot have a public constructor to help instantiation

 * EVERYTHING is a trade-off when it comes to coding.
 */

public enum SingleObject {
	INSTANCE;
	
	//public SingleObject() { };
	
	public void showMessage() {
		System.out.println("Something, something, something, dark side.");
	}

}
