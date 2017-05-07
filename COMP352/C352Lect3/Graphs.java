

import java.text.DecimalFormat;

public class Graphs {

	/**
	 * A simple test method to compare the run-time
	 * of the 7 common growth functions
	 */
	public static void main(String[] args) {
		
		/*
		Constant = 1
		Logarithmic = log n
		Linear = n
		N-Log-N = n log n
		Quadratic = n^2
		Cubic = n^3
		Exponential = 2^n
		*/

		final int CONSTANT = 1;
		DecimalFormat number = new DecimalFormat("0.00"); 
		
		int value[] = {1, 10, 1000, 1000000};
		
		for(int i = 0; i < value.length; i++){
			System.out.println("\nWith input " + value[i] + ": ");
			System.out.println("\tconstant: " + CONSTANT);
			System.out.println("\tlogarithmic: " + number.format(Math.log(value[i])/Math.log(2)));
			System.out.println("\tlinear: " + value[i]);
			System.out.println("\tn log n: " + number.format(value[i] * (Math.log(value[i])/Math.log(2))));
			System.out.println("\tquadratic: " + Math.pow(value[i], 2.0));
			System.out.println("\tcubic: " + Math.pow(value[i], 3.0));
			System.out.println("\texponential: " + Math.pow(2.0, value[i]));
		}
		
	}

}
