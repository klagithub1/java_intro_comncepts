//--------------------------------------------
//Assignment 2
//Written by: Klajdi Karanxha 6173780
//For COMP 249 Section UA
//--------------------------------------------
package creatures;

@SuppressWarnings("serial")
public class WillNotEatException extends Exception {
	
	/**The default constructor takes no arguments and displays the Type of the exception 
	 * throwed*/
public WillNotEatException(){
	super("Interesting, but it is NOT FOOD and I cannot Digest it!");
	
}//end of default constructor
	
	/**The other constructor takes our personalized message when we throw this kind of exception.*/
	public WillNotEatException(final String s1){
		super(s1);
	}//end of other constructor
	

}//end of class
