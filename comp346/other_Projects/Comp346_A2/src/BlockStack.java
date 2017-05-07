//package pa1;
/*
 * KLAJDI KARANXHA 6173780
 * COMP 346 Assignment 1
 * Question 5
 * Re-Implementation of the Class BlockStack
 * NOTE:From NOW on we are working with the original starting order.

 * */
/**
 * Class BlockStack modified as required in Programming Assignment 1 - Question 5
 * Implements character block stack and operations upon it.

 * @author Serguei A. Mokhov, mokhov@cs.concordia.ca;
 * @modifications by Klajdi Karanxha 6173780, klajdi_karanxha@yahoo.it
 * 
 * Inspired by an earlier code by Prof. D. Probst
 *
 * $Revision: 2.0 $
 * $Last Revision Date: 2010/01/28
 * 
 *
 */
class BlockStack
{
											//CLASS VARIABLES//
	/**
	 * # of letters in the English alphabet + 2
	 */
	public static final int MAX_SIZE = 28;

	/**
	 * Default stack size
	 */
	public static final int DEFAULT_SIZE = 6;

	/**
	 * Current size of the stack
	 */
	private int iSize = DEFAULT_SIZE;

	/**
	 * Current pointer on the  top of the stack
	 */
	private int iTop  = 3;

	/**
	 * stack[0:5] with four defined values
	 */
	private char acStack[] = new char[] {'a', 'b', 'c', 'd', '$', '$'};
	
	
	/**
	 * Stack Access Counter is incremented by one each time stack is accessed by one of these methods:
	 * push()
	 * pop()
	 * pick()
	 * getAt()
	 * The stack accessor is private part of the Block Stack and is accessed externally via its proper accessor method.
	 * */
	private static int StackAccessCounter = 0;
	
	
	
	//CLASS CONSTRUCTORS//

	/**
	 * Default constructor
	 */
	public BlockStack()
	{
	}

	/**
	 * Supplied size and constructs the stack
	 */
	public BlockStack(final int piSize)
	{


                if(piSize != DEFAULT_SIZE)
		{
			this.acStack = new char[piSize];

			// Fill in with letters of the alphabet and keep
			// 2 free blocks
			for(int i = 0; i < piSize - 2; i++)
				this.acStack[i] = (char)('a' + i);

			this.acStack[piSize - 2] = this.acStack[piSize - 1] = '$';

			this.iTop = piSize - 3;
                        this.iSize = piSize;
		}
	}
	
	//CLASS METHODS//
	
	//ACCESSOR METHODS//
	
	/**@return StackAccessCounter - a getter method for the counter that can be accessed publicly*/
	public static int getAccessCounter()
	{
		
		return StackAccessCounter;
	}
	
	/**@return iTop*/
	public int getTop()
	{
		return this.iTop;
	}
	
	/**@return iSize*/
	public int getSize()
	{
		return this.iSize;
	}
	/**@return acStack in a safe way*/
	public char[] getAcStack()
	{
		//safely copy the array acStack
		char[] temp = new char[this.acStack.length];
		for(int i = 0; i<= temp.length-1;i++)
		{
			temp[i] = acStack[i];
		}
		return temp;
	}
	
	///**@return acStack as it is*/
	//public char[] getAcStack()
	//{
	//	return this.acStack;
	//}
	
	
	//MUTATOR and OTHER METHODS//
	
	/**Increment the static variable AccessCounter by one each time this method is invoked.
	 * @return nothing */
	private static void incrementStackAccessCounter()
	{
		BlockStack.StackAccessCounter++;
	}
	

	/**
	 * Picks a value from the top without modifying the stack
	 * @return top element of the stack, char
	 */
	public char pick()
	{
		//Increment Access Counter
		BlockStack.incrementStackAccessCounter();
		//return statement
		return this.acStack[this.iTop];
		
		
	}

	/**
	 * Returns arbitrary value from the stack array
	 * @return the element, char
	 */
	public char getAt(final int piPosition)
	{
		//Increment Access Counter
		BlockStack.incrementStackAccessCounter();
		//return statement
		return this.acStack[piPosition];
	}

	/**
	 * Standard push operation
	 */
	public void push(final char pcBlock) throws StackFullException
	{
		if(this.isEmpty())
		{
			this.acStack[++this.iTop] = 'a';
			//Increment Access Counter
			BlockStack.incrementStackAccessCounter();
		}
		else if(this.isFull())
		{
			throw new StackFullException();
		}
		else
		{
			//Increment Access Counter
			BlockStack.incrementStackAccessCounter();
			
			this.acStack[++this.iTop] = pcBlock;
		}
	
	}

	/**
	 * Standard pop operation
	 * @return ex-top element of the stack, char
	 */
	public char pop() throws StackEmptyException
	{
		char cBlock;
		if(this.isEmpty())
		{
			throw new StackEmptyException();
		}
		else
			
		cBlock = this.acStack[this.iTop];
		this.acStack[this.iTop--] = '$'; // Leave prev. value undefined
		//Increment Access Counter
		BlockStack.incrementStackAccessCounter();
		//return statement
		return cBlock;
	}
	/**Checks if the Stack is Empty*/
	public boolean isEmpty()
	{
		if (this.iTop == -1)
		{
			return true;
		}
		else
			return false;
	}
	/**Checks if the stack is full*/
	public boolean isFull()
	{
		if ((this.iSize-1)==iTop)
		{
			return true;
		}
		else
			return false;
	}
	

}

// EOF
