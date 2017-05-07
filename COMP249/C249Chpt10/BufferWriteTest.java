// BufferedWriteTest.java
//
// A test of the difference between buffered writes and unbuffered writes. The timings are done
// with a StopWatch class that is also provided with the sources files from this class.
// To ensure that the timing tests only record the write times, the data to be written is first
// read from a text file and placed into a character array.


import java.io.*;

public class BufferWriteTest {

	static int count;
	static char[] bigCharArray;
	
	public static void main ( String[] aArguments ) throws IOException{
  	
		bigCharArray = buildTheString("BigTextFile.txt");
		
		// the two output streams
        BufferedWriter output1 = new BufferedWriter(new PrintWriter("BigOutFile1.txt"));
        PrintWriter output2 = new PrintWriter("BigOutFile2.txt");
  	
		StopWatch stopwatch = new StopWatch();

		// test the buffered write
		stopwatch.start();
        writeFile(output1);
		stopwatch.stop();
		System.out.println("With buffering: " + stopwatch);

		// test the unbuffered write
		stopwatch.start();
        writeFile(output2);
		stopwatch.stop();
		System.out.println("Without buffering: " + stopwatch);
	}

  
	// read the input file into a character array
	static char[] buildTheString(String fileName) throws IOException{
  	
		int s;
		char[] bigCharArray = new char[250000];
  	
		BufferedReader in = new BufferedReader(new FileReader(fileName));
		count = 0;
		while((s = in.read()) != -1){
			bigCharArray[count++] = (char)s;
		}
		return bigCharArray;
	}
  
  
  
  	static void writeFile(Writer output) throws IOException{
  		
  		for(int i = 0; i < count; i++)
  			output.write(bigCharArray[i]);
  		
  		output.close();
  	}
} 
