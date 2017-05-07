//--------------------------------------------
//Assignment 2
//Written by: Klajdi Karanxha 6173780
//For COMP 249 Section UA
//--------------------------------------------
package creatures;

@SuppressWarnings("serial")
public class CannotEatException extends Exception {
	
	/**The default constructor takes no arguments and displays the Type of the exception 
	 * throwed*/
	public CannotEatException(){
		super("I CANNOT EAT this item like this! I Better unpeel/unwrapp it!!");
	}//end of default constructor

	/**The other constructor takes our personalized message when we throw this kind of exception.*/
	public CannotEatException(final String s1){
		super(s1);
	}//end of constructor 2
	
}//end of CannoEatException class

