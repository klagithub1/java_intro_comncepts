

import java.io.*;

public class TextFileOutputDemo
{
    public static void main(String[] args)
    {
        PrintWriter outputStream = null;
        try
        {
            outputStream = new PrintWriter ("stuff2.txt");
            
        outputStream.println("The quick brown fox");
        outputStream.println("jumped over the lazy dog.");
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Error opening the file stuff.txt.");
            System.exit(0);
        }
        finally {
      			if (outputStream != null)
      				outputStream.close(); // the close() in PrintWriter does not throw any exception...
        }
        System.out.println("Writing to file.");


        System.out.println("End of program.");
    }
}
