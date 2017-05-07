// NeutralOutput.java
//
// Because of the difference in storage or representation formats for the primitive data
// types (int, floats, etc), Java provides stream for reading and writing data in a machine
// independent format. The DataInputStream and DataOutputStream can be used for this purpose. 
// In this file we use DataOutputStream to write a file that hwill later be read by a
// a DataInputStream.
//
// This is a binary format so there are methods for writing primitive data types directly.

import java.io.*;

public class NeutralOutput {

	public static void main(String[] args) throws IOException {
		
		
		String outFile = "NeutralOutput.txt";
		DataOutputStream neutralOut = 
			new DataOutputStream(new BufferedOutputStream (new FileOutputStream (outFile)));
		
		// record one	 
		neutralOut.writeInt(43);
		neutralOut.writeDouble(89.333);
		neutralOut.writeUTF("How are you");
		
		//	record one	 
		neutralOut.writeInt(77);
		neutralOut.writeDouble(0.999998);
		neutralOut.writeUTF("I am fine");
		
		neutralOut.close();
		
	}
}
