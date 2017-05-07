package Assignment1;

public class test {


	/**Takes a string as an input and an integer counter and recursively calculates
	 * all the substrings of that string starting from position 0 up to the counter.
	 * Precondition: counter should be less or equal to the number of characters in the string.*/
	public static String compute(String string, int counter, int position)
	{	
		
		
		//Stopping case, returns the "emptySet" subset.
		if (counter == 0)
		{
			string = "null";
			return  string;
			
			}
			
		//Recursive Case
		else
			counter--;
		
		string =string.substring(0,counter)+" "+compute(string, counter)+" "+" ";
		
		return string;
			
			
		
			
			
		
	}//end of recursive method
	
	
	
	public static void main(String[] args) {
		
		
		System.out.println(test.compute("abc", 4));

	}

}
