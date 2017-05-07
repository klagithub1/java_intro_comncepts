import java.lang.Exception;
/*
 * KLAJDI KARANXHA 6173780
 * COMP 346 Assignment 2
* */



public class StackFullException extends Exception 
{
	/**The default constructor takes no arguments and displays the Type of the exception 
	 * thrown*/
	public StackFullException(){
		super("The Stack is Full!");
	}//end of default constructor
	
	/**The other constructor takes our personalized message when we throw this kind of exception.*/
	public StackFullException(final String s1){
		super(s1);
	}//end of constructor 2
}
