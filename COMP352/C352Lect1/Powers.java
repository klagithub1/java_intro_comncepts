package recursion;

public class Powers {
	
	// calculate exponents using recursive squaring
	public static long power(long x, long n){
		if(n == 0)
			return 1;
	     
		if(n % 2 != 0){ // if n is odd
			long y = power(x, (n - 1)/ 2);
			return x * y * y;
		}	
	    else{ // if n is even
			long y = power(x, n/ 2);
			return y * y;
	    }
	}
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		long x = 4;
		long n = 30;
		
		System.out.println(x + "^" + n + " = " + Powers.power(x, n));
		
	}

}
