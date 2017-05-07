// Sort.java
//
// Arrays can be sorted using the Arrays class in java.util
// If using primitive types, like here, you can just pass the array reference
// to the sort() method. If using objects, you will have to implment the
// Comparable Interface in your new class.


import java.util.Arrays;

public class Sort {

	public static void main(String[] args) {
		
		// create and initialize the array
		int[] unSorted = new int[5];
		
		unSorted[0] = 57;
		unSorted[1] = 17;
		unSorted[2] = 999;
		unSorted[3] = 3;
		unSorted[4] = 179;
		
		System.out.println("Unsorted Array: ");
		for (int i = 0; i < unSorted.length; i++)
			System.out.println("\t" + unSorted[i]);
		

		// now sort it
		Arrays.sort(unSorted);
		
		System.out.println("\n\nSorted Array: ");
		for (int i = 0; i < unSorted.length; i++)
			System.out.println("\t" + unSorted[i]);		
	}
}
