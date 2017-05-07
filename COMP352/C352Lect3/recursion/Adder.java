package recursion;

//import java.util.Arrays;
import java.util.Random;

//import analysis.Sorter;
import analysis.StopWatch;

public class Adder {

	public int[] make_array(int size){  
		  return new int[size]; 
	}
	
	public void initialize_arrays(int[][] arrays){
		
	}
	
	public void populate_array(int[] test){ 
		Random randomGenerator = new Random();
		for(int i = 0; i < test.length; i++){
			test[i] = randomGenerator.nextInt(10);   
		}
	}
	
	public void show_first_ten(int[] test){ 
		int size = (test.length < 10) ? test.length : 10;
		
		System.out.println("\nShowing first ten elements of " + test.length + " element array");
		for(int i = 0; i < size; i++){
			System.out.println(test[i]);
		}
	}
	
	// simple iterative version of the sum method
	public static int loopSum(int[] A){
		
		int sum = 0;
		
		for(int i = 0; i < A.length; i++){
			sum += A[i];
		}
		return sum;
	}
	
	
	
	// linear recursion for the sum method
	public static int lSum(int[] A, int n){
		if(n == 1)
			return A[0];
		else
			return lSum(A, n - 1) + A[n - 1];
	}
	
	
	// binary recursion for the sum method
	public static int bSum(int[] A, int i, int n){
		if(n == 1)
			return A[i];
		
		return bSum(A, i, n/ 2) + bSum(A, i + n/2, n/2);
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		StopWatch stopwatch = new StopWatch();
		//int[] sizes = {2, 1024};
		int[] sizes = {2, 1024, 65536, 1048576};
		int[][] arrays = {null, null, null, null}; 
		
		
		Adder myAdder = new Adder();
		
		
		for(int i = 0; i < sizes.length; i++){
			
			System.out.println("Summing arrays of " + sizes[i] + " integers");
			
			/*
			arrays[i] = myAdder.make_array(sizes[i]);
			myAdder.populate_array(arrays[i]);
			stopwatch.start();
			System.out.println("Sum = " + Adder.lSum(arrays[i], arrays[i].length));
			stopwatch.stop();
			System.out.println("Sum time (Linear Sum): " + stopwatch);
			*/
			
			arrays[i] = myAdder.make_array(sizes[i]);
			myAdder.populate_array(arrays[i]);
			stopwatch.start();
			System.out.println("Sum = " + Adder.bSum(arrays[i], 0, arrays[i].length));
			stopwatch.stop();
			System.out.println("Sum time (Binary Sum): " + stopwatch + "\n");
			
			
			stopwatch.start();
			System.out.println("Sum = " + Adder.loopSum(arrays[i]));
			stopwatch.stop();
			System.out.println("Sum time (loop Sum): " + stopwatch + "\n");
			
			
		}
		

		

	}

}
