// GzipCOmpression.java
//
// A small example that shows how an input file (a java source file) can be gzipped and 
// written to an output file. The file is then de-compressed and printed back to the screen.
//
// The technique is very simple - we only have to specify a Gzip stream and place it into
// the "chain" of stream classes.

import java.io.*;
import java.util.zip.*;


public class GzipCompression {
	
	public static void main(String[] args) throws IOException {
		
		String inFile = "RandomAccess.java";
		String gzipFile = "RandomAccess.java.gz";
		
		// a buffered stream to read the text file
		BufferedReader in = new BufferedReader(new FileReader(inFile));
		
		// the gzip output stream
		BufferedWriter outGzip =
			new BufferedWriter( new OutputStreamWriter (new GZIPOutputStream(new FileOutputStream(gzipFile))));
    
		System.out.println("Writing Gzipped file...");
		
		// read the text file and write it to the gzip stream. The compression is
		// done automatically
		int c;
		while((c = in.read()) != -1)
			outGzip.write(c);
		in.close();
		outGzip.close();
		
		// de-compressed the gzipped file and write it to the screen
		System.out.println("Reading Gzipped file");
		BufferedReader in2 =
			new BufferedReader(new InputStreamReader(new GZIPInputStream(new FileInputStream(gzipFile))));
		
		String s;
		while((s = in2.readLine()) != null)
			System.out.println(s);
	}
} 
