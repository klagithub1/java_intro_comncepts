// NeutralInput.java
//
// Because of the difference in storage or representation formats for the primitive data
// types (int, floats, etc), Java provides stream for reading and writing data in a machine
// independent format. The DataInputStream and DataOutputStream can be used for this purpose. 
// In this file we use DataInputStream to reada file that has previously been written with
// a DataOutputStream.
//
// This is a binary format so there are methods for reading primitive data types directly.


import java.io.*;

public class NeutralInput {

	public static void main(String[] args) throws IOException {
		
		
		String outFile = "NeutralOutput.txt";
		DataInputStream neutralIn = 
			new DataInputStream( new BufferedInputStream (new FileInputStream (outFile)));
		
		// record one
		System.out.print("Record One: ");	 
		System.out.print(neutralIn.readInt() + ", ");
		System.out.print(neutralIn.readDouble() + ", ");
		System.out.println(neutralIn.readUTF());
		
		//	record two
		System.out.print("\nRecord Two: ");	  
		System.out.print(neutralIn.readInt() + ", ");
		System.out.print(neutralIn.readDouble() + ", ");
		System.out.println(neutralIn.readUTF());
		
		neutralIn.close();
		
	}
}
