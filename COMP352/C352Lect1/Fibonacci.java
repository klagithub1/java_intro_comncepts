package recursion;

public class Fibonacci {

	// intuitive, binary recursion for the fibonacci method
	long fib(long n) {
	    if (n <= 1) {
	        return n;
	    } 
	    else {
	        return fib(n - 1)+ fib(n - 2);
	    }
	}
	
	// basic test method
	public static void main(String[] args) {

		int n = 60;
		
		Fibonacci myFib = new Fibonacci();
		
		System.out.println("Fib (" + n + "): " + myFib.fib(n));
		

	}

}
