package fileIO;
//--------------------------------------------
//Assignment 3
//Written by: Klajdi Karanxha 6173780
//For COMP 249 Section UA
//--------------------------------------------
//importing
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.Scanner;

import screenoutput.BinaryNumber;
import screenoutput.NotBinaryNumberException;
//class implementation
/**This driver can be divided in three parts
 * part 1. data entered from user is written into a file.
 *part 2. data is read from that file in the screen.
 *part 3. the same result going in the screen is written into another file.
 *of course the three parts are interconnected and fused together.*/
public class Tester_v2 {

	/**
	 * This  is the second version of the driver, it performs the same 
	 * functions but in this case the input comes from file input.txt 
	 * and goes to file output.txt, which are created in the same directory as the project.
	 */
	public static void main(String[] args) {
		// Welcome message
		System.out.println("\t*********************************************************\t");
		System.out.println("\t WELCOME IN THE BINARY TO DECIMAL CONVERTER PROGRAM (ver.2)\t");
		System.out.println("\t*********************************************************\t");
		
		//Create an 2 output streams.handling also the exceptions
		PrintWriter outputstream=null;
		PrintWriter finalstream=null;
		try {
			outputstream=new PrintWriter(new FileOutputStream("input.txt"));
			finalstream=new PrintWriter(new FileOutputStream("output.txt"));
		} catch (FileNotFoundException e) {
			// When exception thrown message is displayed.
			System.out.println(e.getMessage());
		}//end of catch block
	
		
		//creating a Scanner;
		Scanner kb=new Scanner(System.in);
		Scanner kb2=new Scanner(System.in);
		//Prompting the user to enter five binary numbers.
		System.out.println("Please declare how many binary Strings do you intend to enter:");
		int j=kb.nextInt();
		while(j<=0||j>35)
		{System.out.println("please enter a correct number(less than 35) number");
		j=kb.nextInt();}//end while
		System.out.println("Please enter "+j+" binary numbers (press enter after each number) :");
		//create an array of j strings
		String[] bins=new String[j];
		
		
		int i=0;
		for(i=0;i<=bins.length-1;i++)
		{System.out.println("Enter Binary nr."+(i+1)+":");
		bins[i]=kb2.nextLine();
		outputstream.println(bins[i]);
		System.out.println("Writing: "+ bins[i]+" to input.txt");
		}//end of for loop
		
		System.out.println("Loading data into file... ");
		//closing the stream
		outputstream.close();
		
		/**Now we retreat the lines of the file by reading them and 
		 * use them as arguments for the constructors of our BinaryNumber class*/
		Scanner importstream=null;
		try {
			importstream=new Scanner(new FileInputStream("input.txt"));
		} catch (FileNotFoundException e) {
			// When Exception is encountered a message is displayed on the screen, 
			//and the progrm is terminated
			System.out.println(e.getMessage());
			System.out.println("Ending Program ...");
			System.exit(0);
		}//end of catch block
		System.out.println("\t*******************************\t");
		System.out.println("Now the data entered in the file will be retrieved and converted to decimal.");
		//create another array of Strings
		BinaryNumber[] binarynumbers=new BinaryNumber[j];
		int k=0;
		
		//loop that will initialize j BinaryNumber objects as the lines of the file
		for(k=0;k<=binarynumbers.length-1;k++)
		{
			System.out.println("\nCreating binary number nr."+(k)+" from file input.txt ...");
			binarynumbers[k]=new BinaryNumber(importstream.nextLine());//end of condition
			
		}//end of loop
		//closing the flow
		importstream.close();
	System.out.println("\nConverting to decimal ...");
	System.out.println("\t*******************************\t");
	System.out.println("RESULTS:\n");
		int z=0;
		int[]nr=new int[binarynumbers.length];
		/**This loop will execute the static recursive method for every valid binary number 
		 * and will display the results on the screen and also write them on a file.*/
		for(z=0;z<=binarynumbers.length-1;z++)
		{System.out.println("Displaying result for "+binarynumbers[z].toString()+" :");
			try {nr[z]=BinaryNumber.BinToDec(binarynumbers[z]);
			finalstream.println(String.valueOf(nr[z]));
			System.out.println(" This binary is equivalent to: "+nr[z]);
			
		}//end of try
		catch (NotBinaryNumberException e) {
			// Whenever an Exception is encountered a message is displayed
			System.out.println(e.getMessage());
		}//end of internal catch block
			
		}//end of conversion loop
		
		
		//closing the stream
		finalstream.close();
		
		System.out.println("\nDecimal Numbers displayed on the screen are also available at output.txt");
		System.out.println("\t*******************************\t");
		System.out.println("\tTHANK YOU FOR TESTING MY PROGRAM !\t");//closing message
			
	}//end of main method

}//end of class
