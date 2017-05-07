import java.io.*;
import java.util.Scanner;

public class LineNumberer {
    public static void main(String[] args) {
        Scanner myKeyboard = new Scanner(System.in);

        System.out.print("Enter Input file: ");
        String inputFileName = myKeyboard.next();

        System.out.print("Enter Output file: ");
        String outputFileName = myKeyboard.next();
 
 		Scanner inFile = null;
 		PrintWriter outFile = null;
 		
        try { 
             inFile = new Scanner(new FileReader(inputFileName));
     
	        outFile = new PrintWriter(outputFileName);
          
            int lineNb = 1;
          
        	while (inFile.hasNextLine()) {
                String line = inFile.nextLine();
                outFile.println("/* "+lineNb+" */ " + line);
                lineNb++;
            }
        } // end try

        catch (IOException exception) { 
            System.out.println("Error with file:" + exception);
        }
        finally {
      	
      			if (inFile != null)
      				inFile.close( );
      	
      			if (outFile != null)
      				outFile.close( );

		}
    }
}
