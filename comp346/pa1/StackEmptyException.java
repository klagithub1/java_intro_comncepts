package pa1;
import java.lang.Exception;
/*
 * KLAJDI KARANXHA 6173780
 * COMP 346 Assignment 2
* */



public class StackEmptyException extends Exception 
{
	/**The default constructor takes no arguments and displays the Type of the exception 
	 * thrown*/
	public StackEmptyException(){
		super("The Stack is Empty!");
	}//end of default constructor
	
	/**The other constructor takes our personalized message when we throw this kind of exception.*/
	public StackEmptyException(final String s1){
		super(s1);
	}//end of constructor 2
}
