// Remove.java
//
// For loops work great for most things but they don't work properly
// if we are trying to remove elements from the collection. 

package listsAndIterators;

import java.util.*;



public class Remove {

	public static final int SIZE = 10;
	
	public static void main(String[] args) {
		
		
		ArrayList<Integer> aList = new ArrayList<Integer>();
		
		for(int i = 0; i < SIZE; i++){
			aList.add( new Integer(i));
		}
		
		System.out.println("Print original List1");
		for(Integer myInt: aList)
			System.out.println(myInt);
		
		// this will not produce the expected result
		for(int i = 0; i < aList.size(); i++){
			aList.remove(i);
		}
		
		System.out.println("\nPrint new List1");
		for(Integer myInt: aList)
			System.out.println(myInt);
		
		
		
		ArrayList<Integer> aList2 = new ArrayList<Integer>();
		
		for(int i = 0; i < SIZE; i++){
			aList2.add( new Integer(i));
		}
		
		System.out.println("\nPrint original List2");
		for(Integer myInt: aList2)
			System.out.println(myInt);
		
		// this is the proper way to do this.
		Iterator<Integer> itInt = aList2.iterator();
		while(itInt.hasNext()){
			itInt.next();
			itInt.remove();
		}
		
		System.out.println("\nPrint new List2");
		for(Integer myInt: aList2)
			System.out.println(myInt);
		
		
	}
}
