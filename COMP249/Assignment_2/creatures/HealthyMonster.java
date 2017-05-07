//--------------------------------------------
//Assignment 2
//Written by: Klajdi Karanxha 6173780
//For COMP 249 Section UA
//--------------------------------------------
package creatures;
import Alimentary.*;
public class HealthyMonster extends Monster{
	
	//CONSTRUCTORS
	/**This Constructor Creates a Healthy Monster, gives it a name by calling the superconstructor.
	 * */
	public HealthyMonster(String name){
		//invokes the superconstructor
		super(name);
		
	}//end of HealthyMonsterConstructor

	/**eat() method for HealthyMonster,throws multiple types of exceptions that are to be catched
 * in the Driver Class.Whenever the execution of method ends(with or without changing the Flow of Control)
 * a message is displayed on the Screen.*/
	
	public void eat (BarrelItem item)throws CannotEatException,WillNotEatException,DontLikeException{
		System.out.println("\n"+this.toString()+": Let's see what do we have in here:\n");
		System.out.println(item.toString());
		
		if(item instanceof Treat){
			throw new DontLikeException("I am healthy, ... and I DON'T LIKE Treats");
		}//end of if treat
		
		else if(item instanceof NonFood){
			throw new WillNotEatException("Hey!! I can try to eat it,..but I don't think I will be able to digest it!");
			//exception will be catched in Main method.
			
		}//end of if NonFOOD
		
		else if (item instanceof Pizza){System.out.println("It looks like a Pizza...but, let me first check if it is READY to EAT...");
		Pizza temp2=(Pizza)item;
		boolean check=temp2.isReadyToEat();
		
		if (check==true)
		{try{
			System.out.println("Very Good it is Already UnBoxed. Now let's see if it is covered.");
			if(temp2.HasCover()==true){
		throw new FoodIsCoveredException("Hey! It is covered, I better PREPARE it Before I eat it!");}//end of if has cover
			else
				System.out.println("It is not Covered and unBoxed, what a Good Pizza I will enjoy!");
		}//end of try
		catch (FoodIsCoveredException e){
			System.out.println(e.getMessage());
			temp2.prepare();
			System.out.println("Now that I've PREPARED everything I will enjoy my Pizza!");
		}//end of internally catch of exception
		}//end of if check
		
		else if (check==false){
			throw new CannotEatException();//it willbe catched in the main method.
			
		}//end of else check
		}//end of if Pizza
		
		else if(item instanceof Fruit){
			System.out.println("Mmmmmm... A Fruit! Let's check if it is READY to EAT");
			Fruit temp=(Fruit)item;
			boolean isReady=temp.isReadyToEat();
			
			//Now Checking if it is ready to eat or not
			if(isReady==true){
				try{
				System.out.println("So, it is unpeeled..now let's try to eat it...");
				/**it will launch a FoodIsCovered Exception because all foods are covered.
				 * This Exception will be catched inside the method.*/
				boolean cover=temp.HasCover();
				if(cover==true){
					System.out.println("Let me check if it is covered.");
				throw new FoodIsCoveredException("Hey! this Food is Covered, I have to remove the cover.");
				
				}//end of if has cover
				else
					System.out.println("OK, it is not COVERED and Already unpeeled,looks like I am going to Enjoy it now!!");
				}//end of try
				catch (FoodIsCoveredException e){
					System.out.println(e.getMessage());
					temp.prepare();
					System.out.println("Now tha I've removed the Cover I am gonna enjoy my Fruit!");
				}//end of catch
				}//end of if ready
			
			else if(isReady==false){
				
				throw new CannotEatException("Hey! I CANNOT EAT a peeled fruit!");
			}//end of if not ready!
			
			
			
			
		}//end of if Fruit
		
		
		
		
		
		
	}//end of eat method
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}//end of class
