

// we need to return a pair of integers from each call
// to the fibonacci method. To do this, we define a 
// simple class that holds two integers.
class Pair{
	
	long x;
	long y;
	
	public Pair(long x, long y){
		this.x = x;
		this.y = y;
	}
	
	public long getX(){
		return x;
	}
	public void setX(long x){
		this.x = x;
	}
	
	public long getY(){
		return y;
	}
	public void setY(long y){
		this.y = y;
	}
	
	public String toString(){
		String result = "(";
		result += x;
		result += ", ";
		result += y;
		result += ")";
		return result;
	}
}


// The linear version of the fibonaci method. The main
// idea is to return Fib_k AND Fib_k-1. 
public class FasterFib {

	Pair fib(long k){
	
		if(k == 1){
			return new Pair(k, 0);
		}
		// get the previous two Fib values and use them to
		// calculate the current Fib result
		else{
			Pair result =  fib(k - 1);
			long temp1 = result.getX() + result.getY();
			long temp2 = result.getX();
			result.setX(temp1);
			result.setY(temp2);
			return result;
		}

	}
	
	
	
	/**
	 * basic test method
	 */
	public static void main(String[] args) {
		
		long n = 80;
		
		FasterFib myFib = new FasterFib();
		
		System.out.println("Fib (" + n + "): " + myFib.fib(n));
		
	}

}
