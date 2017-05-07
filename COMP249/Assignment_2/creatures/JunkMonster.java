//--------------------------------------------
//Assignment 2
//Written by: Klajdi Karanxha 6173780
//For COMP 249 Section UA
//--------------------------------------------
package creatures;
import Alimentary.*;
public class JunkMonster extends Monster{
	//CONSTRUCTORS
	/**This is the JunkMonster COnstructor which creates a JunkMonster Object, child of Monster parent class
	 * and gives it a name by calling the Monster() superconstructor.*/
public JunkMonster(String name){
	super(name);
	
}//end of constructor
/**eat() method for JunkMonster,throws multiple types of exceptions that are to be catched
 * in the Driver Class.Whenever the execution of method ends(with or without changing the Flow of Control)
 * a message is displayed on the Screen. */

public void eat(BarrelItem item)throws CannotEatException, DontLikeException{
	System.out.println("\n"+this.toString()+": Let's see what do we have in here:\n");
	System.out.println(item.toString());
	if (item instanceof Fruit){
	
		throw new DontLikeException("Ighhh I am a Junkie Monster and I don't Like Fruit!");
		
	}//end of if
	
	else if (item instanceof NonFood){
		
		System.out.println("I don't know what to do with this OBJECT!?!?");
		
	}//end of if
	
	else if(item instanceof Pizza){System.out.println("Finally a Pizza, let's check if it is READY to EAT...");
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
		throw new CannotEatException();
		
	}//end of else check
	
	}//end of if pizza
	
	
	else if (item instanceof Treat)
	{/**If it is a treat than we parse it to another treat object that points to same memory location, then
	we work with this temporary treat(identical) that we just parsed.*/
		Treat temp1=(Treat)item;
		
		System.out.println("Mmmm... a Treat! Let's Check it if is Ready to Eat first:");
		boolean check=temp1.isReadytoEat();
		if(check==true)
		{	try{
			System.out.println("Now let's see if it is Covered");
			
			if(temp1.HasCover()==true){
				throw new FoodIsCoveredException();
			}//end of if 
			else
			{System.out.println("mmmm I ate the Treat it had no cover and no Wrapping!");}
			}//end of try
			catch (FoodIsCoveredException e){
				System.out.println(e.getMessage());
				
				temp1.prepare();
				
			}//end of catch
			System.out.println("Now that I've prepared everything I am going to enjoy the treat!\n");
		}//end of iterated if
		
		else if(check==false){
			throw new CannotEatException();//it will be catched in the main method.
		
		}//end of iterated else if
		
		
	}//end of else if 
	
	
	
	
	
	
	
}//end of eat method








}//end of class
