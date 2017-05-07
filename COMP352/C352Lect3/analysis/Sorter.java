package analysis;

import java.util.Arrays;
import java.util.Random;

import analysis.StopWatch;


// This program will compare the run-time of Selection Sort
// and Quick Sort. 

public class Sorter {
	
	
	//-----------------------------------------------------------------
	//  Sorts the specified array of objects using the selection
	//  sort algorithm. Basically, find the smallest item and put it in
	//  the first position. Then find the next smallest item from the remaining 
	//  and put it in the second position...and so on.
	//-----------------------------------------------------------------
	public void selectionSort (int[] list){
		int min;
		int temp;

		for (int index = 0; index < list.length-1; index++) {
			min = index;
			for (int scan = index+1; scan < list.length; scan++){
				if (list[scan] - (list[min]) < 0)
					min = scan;
			}

			// Swap the values
			temp = list[min];
			list[min] = list[index];
			list[index] = temp;
		}
	}
	
	
	public int[] make_array(int size){  
		  return new int[size]; 
	}
	
	public void initialize_arrays(int[][] arrays){
		
	}
	
	public void populate_array(int[] test){ 
		Random randomGenerator = new Random();
		for(int i = 0; i < test.length; i++){
			test[i] = randomGenerator.nextInt(1000);   
		}
	}
	
	public void show_first_ten(int[] test){ 
		int size = (test.length < 10) ? test.length : 10;
		
		System.out.println("\nShowing first ten elements of " + test.length + " element array");
		for(int i = 0; i < size; i++){
			System.out.println(test[i]);
		}
	}
	
	
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		StopWatch stopwatch = new StopWatch();
		int[] sizes = {10, 1000, 10000, 100000};
		int[][] arrays = {null, null, null, null}; 
		
		
		Sorter mySorter = new Sorter();
		
		
		
		for(int i = 0; i < sizes.length; i++){
			
			System.out.println("Sorting arrays of " + sizes[i] + " integers");
			
			// the O(n^2) SelectionSort
			arrays[i] = mySorter.make_array(sizes[i]);
			mySorter.populate_array(arrays[i]);
			stopwatch.start();
			mySorter.selectionSort(arrays[i]);
			stopwatch.stop();
			System.out.println(" Sort time (Insertion Sort): " + stopwatch);
			
			// the O(n log n) Quick Sort
			arrays[i] = mySorter.make_array(sizes[i]);
			mySorter.populate_array(arrays[i]);
			stopwatch.start();
			Arrays.sort(arrays[i]);
			stopwatch.stop();
			System.out.println(" Sort time (Quick Sort): " + stopwatch + "\n");
			
		}
		

	}

}
