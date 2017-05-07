// PrimitiveInput.java
//
// Very often, we will process text files that have numberic "fields". We must then convert
// the string version of the numbers into real numbers. This is generally done using the
// "wrapper" classes. For example, the Integer wrapper class provides a method to convert
// a string into an integer. 
//
// Note that you must provide exception handling to catch conversion problems. This example
// does not provide any error handling whatsoever. 

import java.io.*;

public class PrimitiveInput {

	public static void main(String[] args) throws IOException {
		
		String myInFile = "myNumberFile.txt";
		String myOutFile = "myNumberOutFile.txt";
		String inputString;
		String[] tokens;
			
		// Reading input by lines:
		BufferedReader in = new BufferedReader( new FileReader(myInFile));
		PrintWriter out = new PrintWriter(new BufferedWriter( new FileWriter(myOutFile)));

		System.out.println("The input file...\n");
		while((inputString = in.readLine())!= null){
			
			System.out.println(inputString);
			
			// break the record into tokens
			tokens = inputString.split("\\s+");
			
			// convert two integers and a float to their numeric equivalents. The
			// string field needs no conversion
			int intOne = Integer.parseInt(tokens[0]);
			int intTwo = Integer.parseInt(tokens[1]);
			Float floatObject = Float.valueOf(tokens[2]);
			float floatOne = floatObject.floatValue();
			String name = tokens[3];
			
			// print the converted fields to the screen.
			System.out.print("Record: ");
			System.out.print("Int One = " + intOne + ", ");
			System.out.print("Int Two = " + intTwo + ", ");
			System.out.print("Float = " + floatOne + ", ");
			System.out.print("Name = " + name + ", ");
			System.out.println("Sum = " + (intOne + intTwo + floatOne) + "\n");
			
			// now write the values back to a text file using the PrintWriter class.
			// Notice that we add a "sum" field, which demonstrates how we can add the
			// numeric values together.
			out.print("Int One = " + intOne + ", ");
			out.print("Int Two = " + intTwo + ", ");
			out.print("Float = " + floatOne + ", ");
			out.print("Name = " + name + ", ");
			out.println("Sum = " + (intOne + intTwo + floatOne));
			
		}
		in.close();
		out.close();
		
		
		//	Now read the file we just created
		in = new BufferedReader( new FileReader(myOutFile));
			
		System.out.println("\n\nThe output file...");
		while((inputString = in.readLine())!= null){
			System.out.println(inputString);
		}
		in.close();
		
	}
}
