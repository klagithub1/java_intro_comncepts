//FileOutput.java
//
// Reading and writing text. In this case, we are going to read a text file line
// by line and then reverse the order of its words. We will do the writing with a 
// buffered FileWriter stream. Whle this works just fine, note how much easier it is to
// use the PrintWriter for this purpose (see FormattedOuptut.java).

import java.io.*;

public class FileOutput {
  
  	// Throw exceptions to console:
  	public static void main(String[] args) throws IOException{
		
		String myInFile = "myInFile.txt";
		String myOutFile = "myOutFile.txt";
		String inputString;
		String[] tokens;
			
		// Reading input by lines:
		BufferedReader in = new BufferedReader( new FileReader(myInFile));
		BufferedWriter out = new BufferedWriter( new FileWriter(myOutFile));

		System.out.println("The input file...\n");
		while((inputString = in.readLine())!= null){
	
			System.out.println(inputString);
			
			// split the string into token - separated by white space
			tokens = inputString.split("\\s+"); 
			for(int i = tokens.length - 1; i >= 0; i--){
				//out.write(tokens[i], 0, tokens[i].length()); can use this format to write portions of strings
				out.write(tokens[i]);
				out.write(' '); // add a space between words
			}
			out.write('\n');
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