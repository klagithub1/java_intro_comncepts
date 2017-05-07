package Drafts;

public class IllegalMoveException extends Exception
{
		/**
	 * Default Serial ID for this exception.
	 */
	private static final long serialVersionUID = 1L;

		public IllegalMoveException()
		{
			super("Illegal move of the reference node !");
		}
		
		public IllegalMoveException(String s1)
		{
			super(s1);
		}
}
