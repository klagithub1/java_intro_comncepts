// FileInput.java
//
// Java I/O makes heavy use of the Decorator Pattern - chaining together
// a series of I/O stream in order to combine functionality.
//
// This example shows how to create a buffer stream to read data from disk.

import java.io.*;


public class FileInput {
  
  	// Throw exceptions to console:
  	public static void main(String[] args) throws IOException{
		
		String myFile = "Swallow.java";
		BufferedReader in = null;
		
		try{
			// Reading input by lines:
			 in = new BufferedReader( new FileReader(myFile));

			String s = new String();
			int count = 1;
		
			while((s = in.readLine())!= null){
			
				System.out.println(count + ": " + s);
	  			count += 1;
  			}
		}
		catch(FileNotFoundException e){
			System.err.println("Sorry but " + myFile + " isn't here!");
		}
		finally {
      		try {
      			if (in != null)
      				in.close( );
      		}
      		catch(IOException e) {
           		System.out.println("Can't seem to close the file...");
        	}
		}
  	}	
}