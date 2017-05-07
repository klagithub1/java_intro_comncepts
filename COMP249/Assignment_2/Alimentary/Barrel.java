//--------------------------------------------
//Assignment 2
//Written by: Klajdi Karanxha 6173780
//For COMP 249 Section UA
//--------------------------------------------

package Alimentary;
import java.util.Random;
public class Barrel {
	
	
	//Attributes of the Barrel Class
	BarrelItem[] itemsArray;

	//Constructors
	
	/**The default Barrel Constructor takes no arguments and returns an Array of 10 items from
	 * child classes of BarrelItems. Using a randomizing mechanism to choose between the classes
	 * and the same randomizing mechanism to initiate the boolean values for classes Alimentary.Fruit 
	 * and Alimentary.Treat. 80 % of Alimentary.Fruit class objects are initialized Peeled
	 *  and 20% of Alimentary.Treat objects are initialized unWrapped*/
	public Barrel(){
		//creating a random object
		Random rd=new Random();
		
		//create the Array
		itemsArray=new BarrelItem[10];
		
		int i,r1,r2,r3;
		
		for (i=0;i<=itemsArray.length-1;i++){
			r1= rd.nextInt(4);
			
			
			if(r1==0)
			{itemsArray[i]=new NonFood("Cellphone");}//end of if
			
			else if(r1==1){
				r2=rd.nextInt(10);
				if(r2==0||r2==1)
				{itemsArray[i]=new Fruit("Strawberry",false);}
				else
					itemsArray[i]=new Fruit("Orange",true);
			}//end of else if
			
			else if (r1==2)
			{r3=rd.nextInt(10);
			if(r3==0||r3==1)
			{itemsArray[i]=new Treat ("Cotton Candy",false);}
			else
				itemsArray[i]=new Treat ("Toffee",true);}//end of else if
			
			else 
				itemsArray[i]=new Pizza("Veggie",true);
				
			
			
		}//end of for loop 
		
	}//end of default constructor
	
	
		/**This Constructor takes an Array of barrel items as an argument and makes the
		 * itemsArray object attributes from the array of BarrelItems of barrel Class point 
		 * to the same memory location as the objects of the BarrelItem argument array.*/
		public Barrel(BarrelItem[] br1){
			itemsArray=new BarrelItem[br1.length] ;
		int i;
		for(i=0;i<=br1.length-1;i++)
		{itemsArray[i]=br1[i];
			
		}//end of for loop
			}//end of barrel Constructor
	
	/**This method returns an item of the barrel for the eating process done
	 *  by the monsters in the driver class or in the other eating methods.*/
		
		public BarrelItem returnItem(int n){
			
			return itemsArray[n];
		}//end of return item.
		
		/**This is an overloaded constructor that takes an integer as an input and
		 * creates a Barrel with that nr. of Random Items.The items are chosen from the list of 8 Random items given
		 * as default.*
		 * /
		 
		 */
		public Barrel(int siz){
			//creating a random object
		Random rd=new Random();
		
		//create the Array
		itemsArray=new BarrelItem[siz];
		
		int i,r1,r2,r3;
		
		for (i=0;i<=itemsArray.length-1;i++){
			r1= rd.nextInt(4);
			
			
			if(r1==0)
			{itemsArray[i]=new NonFood("Cellphone");}//end of if
			
			else if(r1==1){
				r2=rd.nextInt(10);
				if(r2==0||r2==1)
				{itemsArray[i]=new Fruit("Strawberry",false);}
				else
					itemsArray[i]=new Fruit("Orange",true);
			}//end of else if
			
			else if (r1==2)
			{r3=rd.nextInt(10);
			if(r3==0||r3==1)
			{itemsArray[i]=new Treat ("Cotton Candy",false);}
			else
				itemsArray[i]=new Treat ("Toffee",true);}//end of else if
			
			else 
				itemsArray[i]=new Pizza("Veggie",true);
				
			
			
		}//end of for loop 
			
		}//end of Overloaded Constructor
		
	/**This method returns an integer representing the number of 
	 * Barrel Items in the Barrel, when created with the second constructor especially.*/
	
	public int getItemCount(){
		
		return itemsArray.length;
	}//end of itemcount
	
	/**This method shows the content of an array of items contained in the Barrel,
	 * it invokes the toString methods of the subclasses of BarellItem Class.
	 * */
	
	
	public void showContents(){
		
		System.out.println("This Barrel contains the following items:\n" +
				"");
		int u;
		for(u=0;u<=itemsArray.length-1;u++){
			System.out.println(itemsArray[u].toString());
		}//end of for loop
	}//end of showContents
	
	
	
	
}//end of barrel class
