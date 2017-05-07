package recursion;

public class PowersBinary {
	
	// this is another version of recursive squaring. In this
	// case, we call the recursive function twice to do the
	// squaring. Ultimately, we will create a binary tree
	// of recursive calls. So instead of being logarithmic,
	// algorithm will now be linear.
	public static long otherPower(long x, long n){
		
		if(n == 0)
			return 1;
	     
		if( (n % 2) != 0){ // if n is odd
			long y = otherPower(x, (n - 1)/2) * otherPower(x, (n - 1)/2);
			return x * y;
		}	
	    else{ // if n is even
			long y = otherPower(x, n/2) * otherPower(x, n/2);
			return y;
	    }
	    
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		long x = 4;
		long n = 30;
		
		System.out.println(x + "^" + n + " = " + PowersBinary.otherPower(x, n));
		

	}

}
