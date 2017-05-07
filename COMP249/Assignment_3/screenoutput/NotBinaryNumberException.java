package screenoutput;
//--------------------------------------------
//Assignment 3
//Written by: Klajdi Karanxha 6173780
//For COMP 249 Section UA
//--------------------------------------------
@SuppressWarnings("serial")
public class NotBinaryNumberException extends Exception{
	/**The default exception constructor that
	 *  calls the superconstructor by inserting our default message*/
	public NotBinaryNumberException(){
		
		super("Error !The number entered is not binary.");
	}//end of default constructor
	/**The second overloaded constructor that takes a string 
	 * argument and makes of it our message, in case of an Exception occurring.*/
	public NotBinaryNumberException(final String message){
		super(message);
	}//end of second constructor
}//end of exception class
