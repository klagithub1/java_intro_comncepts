//--------------------------------------------
//Assignment 2
//Written by: Klajdi Karanxha 6173780
//For COMP 249 Section UA
//--------------------------------------------
package creatures;

//These are the packages we need to implement our driver class:

import java.util.Scanner;

//We include the import of all the alimentary classes
//because we will redirect to them in our main class.
import Alimentary.*;




//our Driver Class
public class EatingTime {

	/**This program creates two Monsters a Healthy and a Junk Monster.
	 * It propmpts the user to create a Barel with barrel items,by using one of the overloaded constructors
	 * of Barrel Class.
	 * Then it invokes the static method drawAndEatItem whic itself invokes the eat method specific to each monster
	 * that takes the barrel and displays how the monsters react ot food or other objects.
	 * The type of Monster who starts the eating process is randomized in the drawAndEatItem static method itself.*/
	public static void main(String[] args) {
		
		//Create Scanner Objects.
		Scanner kb=new Scanner(System.in);
		Scanner st=new Scanner(System.in);
		Scanner bl=new Scanner(System.in);
		//Welcome message
		System.out.println("\t Welcome to my Testing Driver for the two monsters eating process!\t");
		System.out.println("\t *****************************************************************\t");
		//Create the two monsters
		HealthyMonster BAR=new HealthyMonster("BAR");
		JunkMonster FOO=new JunkMonster("FOO");
		
		System.out.println("First Let me introduce you to our two monsters:");
		System.out.println("Our Healthy Monster is called:"+BAR.toString());
		System.out.println("Our Junk Monster is called:"+FOO.toString());
		System.out.println("As a Second Step we will need to create a Barrel of alimentary items(or not)\n" +
				"that will be sent in the monsters cave.");
		
		//Creating the barrel
		Barrel barrel = null;
		//Prompting the User
		
		System.out.println("Please clearly choose one of the following options:\n" +
				"1. FILL BARREL AUTOMATICALLY WITH 10 RANDOM ITEMS.\n" +
				"2. FILL BARREL AUTOMATICALLY WITH A USER-DEFINED Nr. OF ITEMS.\n" +
				"3. FILL BARREL MANUALLY WITH A USER-DEFINED Nr.OF ITEMS.");
//		Create an Integer that indicates user's choice.
		int choice;
		choice=kb.nextInt();
		//A while loop to make sure the user enters a correct integer.
		while(choice<=0||choice>=4){
			System.out.print("Please enter a valid input _");
			choice=kb.nextInt();
		}//end of while
		
	//Now we evaluate the user's first choice
		/**If user enters 1 the Barrel is initialized randomly*/
		if(choice==1){
			 barrel=new Barrel();
		
		}//end of if 1
		/**if user enters 2 the barrel is initialized to a specific nr. of elements*/
		else if(choice==2){
			System.out.println("Please indicate how many random items you want in the barrel: ");
			int items;
			items=kb.nextInt();
			while(items<=0||items>=30){
				
				System.out.println("Please provide a correct value, between 1 and 29! _");
				items=kb.nextInt();
			}//end of while
			 barrel=new Barrel(items);
		}//end of if 2
		/**In case the users enters 3, we go to a sub program that prompts the user to create step-by step an array of 
		 * BarrelItems to fill the Barrel
		 * nad then inputm that array as an argument when we create our barrel.*/
		else if(choice==3){
			System.out.println("Please indicate how many items you want in the barrel: ");
			int nrOfitems;
			nrOfitems=kb.nextInt();
			while(nrOfitems<=0||nrOfitems>=15){
				
				System.out.println("Please provide a correct value, between 1 and 15! _");
				nrOfitems=kb.nextInt();
			}//end of while
			//Creating an user defined size array of barrel Items.
			
			BarrelItem[] barritem=new BarrelItem[nrOfitems];
			
			System.out.println("Now Please Specify your items one-by-one: _");
			int i;
			/**This Loop will throw several prompts and will ask the user to define 
			 * the class and the arguments of each barrelItem
			 * basically it will  explicitly invoke class specified Constructors 
			 * to create user defined objects.*/
			
			for(i=0;i<=barritem.length-1;i++){
				System.out.println("What Type is Item Nr."+(i+1)+" ? _\n" +
						"1. NonFood\n" +
						"2. Fruit\n" +
						"3. Treat\n" +
						"4. Pizza\n");
				int wtype;
				wtype=kb.nextInt();
				
				//now we evaluate the options
				while (wtype>=5||wtype<=0){
					System.out.println("Please enter a correct choice: ");
					wtype=kb.nextInt();
				}//end of while
				
				if(wtype==1){
					//name defined
					System.out.println("You've chosen a NonFood Item. Please Provide a name for it _");
					String name ;
					name=st.next();
					barritem[i]=new NonFood(name);
					}//end of first if
				else if(wtype==2){
					System.out.println("You've chosen a Fruit. Please Provide a name for it _");
					String name ;
					name=st.next();
					//this determines if it is peeled or not.
					boolean b;
					
					
						System.out.println("Is it Peeled? Please clearly write: true or false");
					b=bl.nextBoolean();
					
//					create the fruit
					barritem[i]=new Fruit(name,b);
					
					
				}//end of if 2
				
				if(wtype==3){
					System.out.println("You've chosen a Treat. Please Provide a name for it _");
					String name ;
					name=st.next();
					//this determines if it is wrapped or not.
					boolean b;
					
					
						System.out.println("Is it Wrapped? Please clearly write: true or false");
					b=bl.nextBoolean();
					
//					create the Treat
					barritem[i]=new Treat(name,b);
					
				}//end of if 3
				
				else if(wtype==4){
					System.out.println("You've chosen to create Pizza. Please Provide a name for it _");
					String name ;
					name=st.next();
					//this determines if it is Boxed or not.
					boolean b;
					
				
						System.out.println("Is it in a Box? Please clearly write: true or false");
					b=bl.nextBoolean();
					
//					create the PIZZA
					barritem[i]=new Pizza(name,b);
					
				}//end of pizza choice
				
			}//end of for loop
			
			barrel=new Barrel(barritem);
			
		}//end of third choice
		
		
	
		System.out.println("\t*************************\t");
		//Showing the number of items and the content of the created barrel.
		System.out.println("Congratulations on creating your barrel with "+barrel.getItemCount()+" items");
		barrel.showContents();
		System.out.println("\t*************************\t");
		
		System.out.println("\nNow the Barrel is being shipped to the two monsters...\n");
		System.out.println("As soon as they saw the barrel, our two monsters opened it and began to draw items out from it.");
		System.out.println(FOO.toString()+" and "+BAR.toString()+ ": Hey A barrel of Food! Let's check it out! ");
		System.out.println("___________________________________________________________________________");
		/**Now we call the static method that will Take as an argument the user created barrel 
		 * and the two monsters and show step by step how the Monsters eat the food(or react to it)*/
		Monster.drawAndEatItem(barrel, BAR, FOO);
		//Closing message
		System.out.println("\t \t");
		System.out.println(BAR.toString()+" and "+FOO.toString()+":THANK YOU FOR FEEDING TWO MONSTERS LIKE US!");
		System.out.println("\t**********************************************************************\t");
		System.out.println("Thank You for Testing my Program!");
		

	}//end of main method

}//end of driver class
