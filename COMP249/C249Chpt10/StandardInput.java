// StandardInput.java
//
// It is sometimes useful to be able to get information from the console (Java
// does provide some convenience classes for this now). It is very easy to map
// Java "Standard Input" to a buffer input stream so that you can read from
// the keyboard.

import java.io.*;

public class StandardInput {
  
	// Throw exceptions to console:
	public static void main(String[] args) throws IOException{
		
		// Reading from standard input
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		String s = new String();
		int count = 1;
		
		System.out.print("Enter a line:");
		s = stdin.readLine();
 		System.out.println("\nWoo hoo, you just typed: " + s);
			
	}
}
