package screenoutput;
//--------------------------------------------
//Assignment 3
//Written by: Klajdi Karanxha 6173780
//For COMP 249 Section UA
//--------------------------------------------
//import Scanner;

import java.util.Scanner;

/**This is our driver class*/
public class Tester{
	/**This is our main method that will execute our functions created in the BinaryNumber class. */
	public static void main(String[] args){
	//Welcome message:
		System.out.println("\t***********************************************\t");
		System.out.println("\t**** WELCOME TO THE BINARY CONVERTER PROGRAM ****\t");
		System.out.println("\t***********************************************\t");

//create a Scanner object
		Scanner kb=new Scanner(System.in);
		//create a BinaryNumber object;
		BinaryNumber binnumber=new BinaryNumber();
//prompt the user to initiate it:
		System.out.println("");
		System.out.println("Please enter a binarynumber (the first character should be 1 !)\n");
		System.out.println("(999 to quit)");
		String userentry=null;
		userentry=kb.next();
		//The quit option
		while(Integer.parseInt(userentry)!=999)
		{
		//set the object to user entry
			
		binnumber.setBinary(userentry);
		System.out.println("---");
		System.out.println("You've entered: "+binnumber.toString()+"\n");
		//recursive method calculation
		//first we bound with try catch in order to catch the exception the method throws
		try {
			System.out.println("\nThe decimal value of your binary number is: "+BinaryNumber.BinToDec(binnumber));
		} catch (NotBinaryNumberException k) {
			// When Exception catched Exit the program
			System.out.println(k.getMessage());
			System.out.println("Terminating Program ...");
			System.exit(0);
		}//end of catch
		System.out.println("\nPlease enter another binary number(999 to quit)");
		userentry=kb.next();}//end of while loop
		//end of program message
		System.out.println("\t*************************************************\t");
System.out.println("Thank You for testing the binary to decimal number converter program!");


}//end of main method
	}//end of Tester class