// FormattedOutput.java
//
// Reading and writing text. In this case, we are going to read a text file line
// by line and then reverse the order of its words. We will do the writing with a 
// buffered Printwriter stream. Note how much simpler and more flexible this is than
// using the buffered FileWriter in FileOutput.java. Specifcally, you can write java 
// primitives to the file along with text.

import java.io.*;


public class FormattedOutput {
  
  	// Throw exceptions to console:
  	public static void main(String[] args) throws IOException{
		
		String myInFile = "myInFile.txt";
		String myOutFile = "myOutFile.txt";
		String inputString;
		String[] tokens;
			
		// Reading input by lines:
		BufferedReader in = new BufferedReader(new FileReader(myInFile));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(myOutFile)));

		System.out.println("The input file...\n");
		while((inputString = in.readLine())!= null){
			
			System.out.println(inputString);
			
			// split the line into words
			tokens = inputString.split("\\s+");
			for(int i = tokens.length - 1; i >= 0; i--){
				// use a print method - can add primitive java types as well
				out.print( "(" + i + ")" + tokens[i] + " ");
			}
			out.println();
  		}
		in.close();
		out.close();
			
		
		// now let's read the file we've written
		in = new BufferedReader( new FileReader(myOutFile));
			
		System.out.println("\n\nThe output file...\n");
			while((inputString = in.readLine())!= null){
				System.out.println(inputString);
		}
		in.close();
			
  	}
}