/*KLAJDI KARANXHA
     * 6173780
     * COMP249 Section U
     * Assignment 4*/
package Question2;

/*This is the predefined class from the book which defines a static method that takes an array of
 * comparable items and if the compareTo method is well defined by programmer no- matter what are 
 * the objects implementing Comparable interface ,that fill in the array This method will sort them 
 * from decreasing to increasing order.*/

/*What I've added to this class is a method that takes only one Comparable array and sorts it for all the elements.
 * As required in the Question 2 of the assignment*/
public class GeneralizedSelectionSort
{
    /**
     Precondition: numberUsed <= a.length;
                  The first numberUsed indexed variables have values.
     Action: Sorts a so that a[0, a[1], ... , a[numberUsed - 1] are in
     increasing order by the compareTo method.
    */
    public static void sort(Comparable[] a, int numberUsed)
    {
        int index, indexOfNextSmallest;
        for (index = 0; index < numberUsed - 1; index++)
        {//Place the correct value in a[index]:
            indexOfNextSmallest = indexOfSmallest(index, a, numberUsed);
            interchange(index,indexOfNextSmallest, a);
             //a[0], a[1],..., a[index] are correctly ordered and these are 
             //the smallest of the original array elements. The remaining
             //positions contain the rest of the original array elements.
        }
    }

    /**
     Returns the index of the smallest value among
     a[startIndex], a[startIndex+1], ... a[numberUsed - 1]
    */
    @SuppressWarnings("unchecked")
	private static int indexOfSmallest(int startIndex,
                                        Comparable[] a, int numberUsed)
    {
        Comparable min = a[startIndex];
        int indexOfMin = startIndex;
        int index;
        for (index = startIndex + 1; index < numberUsed; index++)
            if (a[index].compareTo(min) < 0)//if a[index] is less than min
            {
                min = a[index];
                indexOfMin = index;
                //min is smallest of a[startIndex] through a[index]
            }
        return indexOfMin;
    }
    
    /** 
     Precondition: i and j are legal indices for the array a.
     Postcondition: Values of a[i] and a[j] have been interchanged.
    */
    private static void interchange(int i, int j, Comparable[] a)
    {
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp; //original value of a[i]
    }
    
    /*My added method*/
    /**This is my added method as required in question 2 of the assignment.
     * sortAll takes a complete array of Comparable, and sorts it all in the increasing order.
     * objects of the array have to implement Comparable interface and user has to well define a compareTo method
     * (in my case for the InventoryItem class).This method also invokes some of the book defined methods of this class
     * **Klajdi Karanxha***/
    public static void sortAll(Comparable[] arr) 
    {
    	// creating counters
    	int i, indexOfNextSmallest;
        for (i = 0; i <= arr.length-1; i++)
        {//Place the correct value in arr[i]:
            //Calls the method indexOfSmallest()
        	try
        	{
        	indexOfNextSmallest = indexOfSmallest(i, arr, arr.length);
            //Calls the method interchange
            interchange(i,indexOfNextSmallest, arr);
        	}
        	catch(NullPointerException e)
        	{
        		System.out.println(e.getMessage());
        		System.out.println("ERROR! Some/all of the items of the array are uninitialized!");
        		System.exit(0);
        		
        	}
        }
    }
}
   