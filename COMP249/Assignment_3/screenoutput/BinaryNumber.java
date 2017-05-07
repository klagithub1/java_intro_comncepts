package screenoutput;

//--------------------------------------------
//Assignment 3
//Written by: Klajdi Karanxha 6173780
//For COMP 249 Section UA
//--------------------------------------------
public class BinaryNumber {

	//class attributes
	/**The binumber attribute is a string of binary characters.*/
	private String binumber;
	//Static variables
	/**The static variable counter is needed to keep track of the powers of two*/
	private static double counter=0.00;
	/**The static varaible total is needed to store the decimal number, after conversion*/
	private static double total;
	
	//Constructors
	/**The default constructor takes no argument and initializes the String attribute to null.*/
	public BinaryNumber(){
		binumber=null;
	}//end of default constructor
	/**The second constructor overloaded takes a string as an argument and sets the
	 * instance variable to that string.It doesn't check the string for exceptions.*/
	public BinaryNumber(String arg){
		binumber=arg;
	}//end of other constructor
	
	
	//mutator and accessor methods
	/**getBinary() - returns the instance variable of type string.*/
	public String getBinary(){
		return binumber;
	}//end of getBinary
	/**THis method returns the length of the binary string instance variable*/
	public int getLength(){
		/**since it is referred to, by an static method the return type does not refer directly to the variable.*/
		int temp=binumber.length();
		return temp;}
	
	/**zThe void method takes a String as an argument and sets the instance variable to that string.*/
	public void setBinary(String setting){
		binumber=setting;
	}//end of setBinary
	
	

	//toString method
	/**The toString method displays the content of an Object, in form of a string of characters.*/
	public String toString(){
	return binumber;	
	}//end of toString()
	
	//the recursive void methods
	//The static method that converts binary to decimal can be implemented in two (or more ) ways.
	
	/**This method takes a BinaryNumber type as an argument, parses its integers, recursively calculates 
	 * the decimal equivalent of the binary, and returns the result in form of an Integer.
	 * It throws NotBinaryNumberException if the content of the BinaryNumber is a String which contain
	 * other characters than "1" or "0". The Exception is catched in/or another method or driver class.
	 * All inputs should contain a String starting with "1" but this case is supposed as commonly understood.*/
	public static int BinToDec(BinaryNumber binarystring)throws NotBinaryNumberException{
		//checks for errors or exceptions!
		int i;
		/**this loop goes through every character of the string*/
		for(i=0;i<=binarystring.getLength()-1;i++)
		{String temp=binarystring.getBinary();
		/**if the Unicode of any character is different than the Unicode of 1 or 0
		 * (currently 49 and 48)than an exception is thrown*/
			if(temp.codePointAt(i) > 49 || temp.codePointAt(i)< 48)
				{throw new NotBinaryNumberException("ERROR! The number entered is not a binary Number.");}
			}//ends for loop
		//*************************************************
		//Parsing for every method execution
		int bin=Integer.parseInt(binarystring.getBinary());
		//***********************************************
		//start of recursion
		//Stopping case that stops recursion
		if(bin/10==0)
		{/**The Stopping case number. will be multiplied with 2 to 
		the power of the incremented counter*/
			total=bin*Math.pow(2.0,counter);}
		else
		{int newbin=bin/10;
		
			String s1=String.valueOf(newbin);
		binarystring.setBinary(s1);
		counter++;
//		Recursive calculation
		BinToDec(binarystring);//*****************
		counter--;//sfter the recursive method is returned here, we decrement the counter.
		int j=bin%10;//modula of binary  number with 10 is either 1 or 0.
		total=total+j*Math.pow(2.0, counter);	
		}//end of else
		return (int) total;//return a integer which is our decimal.
	}//end of recursive method
	
/**This is another implementation of the static method,without involving a BinaryNumber 
 * instance variable, in fact this method takes an
 * integer as an argument ,expected a binary integer and returns its equivalent in decimal 
 * by performing it recursively. It doesn't throw an Exception and will not work if the binary 
 * integer contains other elemnts than 1 or 0.*/
static int BinToDec(int binary){
		/**Stopping case.*/
		if(binary/10==0)
		{int n=binary;
		total=n*Math.pow(2.0, counter);
		System.out.println(total);}
			
		else
			{counter++;
			/**Recursive calculation*/
			BinToDec(binary/10);
			counter--;//afterwards this method will be returned here.
		int j=binary%10;
		total=total+j*Math.pow(2.0,counter);
		System.out.println(total);}
			
			return (int) total;
			
			
	}//end of method
	
}//end of BinaryNumber class
