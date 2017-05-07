// ReadAsText.java
//
// This file attempts to read the file written by teh DataOutputStream in NeutralOutput.java
// That was a binary machine independent file. It is not text so this read in this program will
// fail.


import java.io.*;

public class ReadAsText {

	public static void main(String[] args) throws IOException {
		
		String myInFile = "NeutralOutput.txt";
		String inputString;
		String[] tokens;
			
		// Reading input by lines:
		BufferedReader in = new BufferedReader( new FileReader(myInFile));
		
		System.out.println("The input file...\n");
		while((inputString = in.readLine())!= null){
			
			System.out.println(inputString);
			tokens = inputString.split("\\s+");
			
			// this isn't going to work because the file was not text
			int intOne = Integer.parseInt(tokens[0]);
			int intTwo = Integer.parseInt(tokens[1]);
			Float floatObject = Float.valueOf(tokens[2]);
			float floatOne = floatObject.floatValue();
			String name = tokens[3];
		}
		in.close();
	}
}
