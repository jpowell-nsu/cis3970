package driver;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Driver {

	public static void main(String[] args) throws IOException {
		
		/* 1,bird,37.0
		 * 2,word,42.42
		 * 
		 * 1 bird 37.0
		 * 2 word 42.42
		 */
		
		toBinary();
		toText();
	}
	
	public static void toBinary() throws IOException {
		DataOutputStream dostream = new DataOutputStream(new FileOutputStream("files/data.bin"));
				
		dostream.writeInt(1);
		dostream.writeUTF("bird");
		dostream.writeDouble(37.0);
		
		dostream.writeInt(2);
		dostream.writeUTF("word");
		dostream.writeDouble(42.42);
		
		dostream.close();
	}
	
	public static void toText() throws IOException {
		DataInputStream distream = new DataInputStream(new FileInputStream("files/data.bin"));
		
		while (distream.available() > 0) {
			int value1 = distream.readInt();
			String word = distream.readUTF();
			double value2 = distream.readDouble();
			System.out.println(value1 + " " + word + " " + value2);
		}
		
		distream.close();
	}

}
