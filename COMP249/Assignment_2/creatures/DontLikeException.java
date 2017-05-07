//--------------------------------------------
//Assignment 2
//Written by: Klajdi Karanxha 6173780
//For COMP 249 Section UA
//--------------------------------------------
package creatures;

@SuppressWarnings("serial")
public class DontLikeException extends Exception {
	

	/**The default constructor takes no arguments and displays the Type of the exception 
	 * throwed*/
public DontLikeException(){
	super("Arrrghhh!!! ... I do DON'T LIKE this things!");
	
}//end of default constructor
	
	/**The other constructor takes our personalized message when we throw this kind of exception.*/
	public DontLikeException(final String s1){
		super(s1);
	}//end of other constructor
	
	
}//end of class
