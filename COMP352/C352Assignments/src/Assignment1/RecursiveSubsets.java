package Assignment1;

public class RecursiveSubsets
{
	
	/**Takes a string as an input and an integer counter and recursively calculates
	 * all the substrings of that string starting from position 0 up to the counter.
	 * Precondition: counter should be less or equal to the number of characters in the string.*/
	public static String compute(String sentence,int counter)
	{	
		
		//Error condition.
		if(counter > sentence.length())
			{System.out.println("ERROR: Counter should be no more than " +
					sentence.length()+" !");
				//Adjust counter
				counter = sentence.length();
			}
		
		//Stopping case, returns the "emptySet" subset.
		if (counter == 0)
		{
			sentence= "emptySet- ";
			return sentence;
			}
			
		//Recursive Case
		else
			
			counter--;
		
		
		sentence = sentence+" "+compute(sentence.substring(0,counter),counter)+" ";
		
			return sentence;
	
	}//end of recursive method

	//Test the recursive method
	public static void main(String[] args)
	{
		
		//prints the subsets.
		System.out.println(RecursiveSubsets.compute("abc",3));
	}
}
