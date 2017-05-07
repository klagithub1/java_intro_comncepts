/*KLAJDI KARANXHA
     * 6173780
     * COMP249 Section U
     * Assignment 4*/
package Question2;

import java.util.Scanner;
import java.util.Random;

public class InventoryItemTester 
{

	/**
	 * This Test Program will test our created class InventoryItems that implements a Comparable interface,
	 * It will create an array of Comparable items, and sort them in increasing item ID order by using one 
	 * of the static methods provided from the book,or the method that takes only one array of Comparable 
	 * and sorts all of its content.
	 */
	public static void main(String[] args) 
	{
		//Opening
		System.out.println("\t\t**********************************************\t\t");
		System.out.println("Welcome to my Comparable Interface Tsting program!\n\n");
		// Create an array of 10 objects
		InventoryItem[] book=new InventoryItem[10];
		
		//initialize objects to default
		int counter;
		for(counter=0;counter<=book.length-1;counter++)
		{
			book[counter]=new InventoryItem();
		}
		//reset counter
		counter=0;
		

		//Initialize book names
		
		for(counter=0;counter<=book.length-1;counter++)
		{
			book[counter].setName("some_book_title");
		}
		//reset counter
		counter=0;
		
		//Create a random object
		Random rand_ID = new Random();
		int ID=0;
		
		//Initialize Random ID's
		for(counter=0;counter<=book.length-1;counter++)
		{	ID=rand_ID.nextInt(9999);
			if(ID==0)
			{
				//No ID should be 0 so we just ad one to it
				ID=ID+1;
			}
	
			book[counter].setID(ID);
			//0 index is not valid 
			
		}
		//reset counter
		counter=0;
		
		//Display the Array on the screen Unsorted
		System.out.println("This is the content of the unsorted array of items in Inventory:\n");
		for(counter=0;counter<=book.length-1;counter++)
		{	
			System.out.println(book[counter].toString());
		}
		
		
		
		/*In this part we prompt the user if he/she want to sort all of or a part of the items*/
		
		Scanner input= new Scanner(System.in);
		int choice;
		
		//display message
		System.out.println("You have these two options:\n1. To sort all the items press 1.\n2.To sort some of them press 2\n ");
		choice=input.nextInt();
		//to make sure the user stays between 1 and 2
		while(choice>2||choice<1)
		{
			System.out.println("Wrong choice, please retry:\n");
			choice=input.nextInt();
		}
		
		//option 1 - sort all
		if(choice==1)
		{
			//Sort all the array of book items
			GeneralizedSelectionSort.sortAll(book);
			System.out.println("The totally ordered set of items in inventory is:\n");
			
			//initialize a counter
			int count;
			for(count=0;count<=book.length-1;count++)
			{
				System.out.println(book[count].toString());
			}
		}
		//option 2 - sort partially
		else if (choice==2)
		{
			//create an integer
			int nrSort;
			System.out.println("How many of the items do you want to sort?:");
			nrSort=input.nextInt();
			//Item sorted should be between the borders of the array
			
			while(nrSort>=book.length||nrSort==1)
			{
				System.out.println("Number of items you want to sort should be smaller that total number of items.\n" +
						"Please retry:\n");
				//retry
				nrSort=input.nextInt();
			}
			
			//Sort part of the array of book items
			GeneralizedSelectionSort.sort(book,nrSort);
			System.out.println("The partially ordered set of items in inventory is:\n");
			
			//initialize a counter
			int count=0;
			for(count=0;count<=book.length-1;count++)
			{
				System.out.println(book[count].toString());
			}
		}
		
		//Closing message
		System.out.println("\t\t**********************************************\t\t");
		System.out.println("Thank you for considering the time to test my program!");
	
	}//end main

}//end class
