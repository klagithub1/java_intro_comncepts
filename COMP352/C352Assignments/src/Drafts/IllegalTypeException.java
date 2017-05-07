package Drafts;

public class IllegalTypeException extends Exception 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IllegalTypeException()
	{
		super("Illegal operation for this type of file !");
	}
	
	public IllegalTypeException(String s1)
	{
		super(s1);
	}
}
