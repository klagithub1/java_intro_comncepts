package listsAndIterators;

/**
 * Runtime exception thrown when one tries to perform operation top or
 * pop on an empty stack.
 */

public class InvalidPositionException extends RuntimeException {  
	public InvalidPositionException(String err) {
		super(err);
	}
}
