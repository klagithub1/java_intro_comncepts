// MemoryInput.java
//
// The stream abstraction can be used to read/write data from a variety
// of sources and sinks. IN this case, we read data from an in-memory String,
// rather than a disk file.



import java.io.*;

public class MemoryInput {
  
	// Throw exceptions to console:
	public static void main(String[] args) throws IOException{
		
		// Reading from an in-memory string
		TextBuilder builder = new TextBuilder();
		String bigUglyString = builder.getBigUglyString();
		
		StringReader in = new StringReader(bigUglyString);
   		int c;
  		
  		System.out.println("Reading a string from memory...\n");
  		while((c = in.read()) != -1)
	 		System.out.print((char)c);
	}
}


// a class that just provides a giant string
class TextBuilder{
	
  String bigUglyString = 
	
	"So she went into the garden to cut a cabbage-leaf, to \n" + 
	"make an apple-pie; and at the same time a great \n" + 
	"she-bear, coming up the street, pops its head into the \n" + 
	"shop. 'What! no soap?' So he died, and she very \n" + 
	"imprudently married the barber; and there were \n" + 
	"present the Picninnies, and the Joblillies, and the \n" + 
	"Garyalies, and the grand Panjandrum himself, with the \n" + 
	"little round button at top, and they all fell to playing \n" + 
	"the game of catch as catch can, till the gun powder ran \n" + 
	"out at the heels of their boots. \n\n" + 
	"Samuel Foote 1720-1777";
	
	String getBigUglyString(){
		return bigUglyString;
	}
	
}