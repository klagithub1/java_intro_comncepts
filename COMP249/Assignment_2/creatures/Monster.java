//--------------------------------------------
//Assignment 2
//Written by: Klajdi Karanxha 6173780
//For COMP 249 Section UA
//--------------------------------------------
package creatures;

import Alimentary.*;
import java.util.Random;
public class Monster {
	//attributes
	protected String name;
	
	
	//Constructors
	/**This is the Monster Constructor that takes a String and uses it as a Monster Name.*/
	public Monster(String name)
	{this.name=name;}
//void methods
	/**The drawAndEatItem(Barrel args,HealthyMonster amonster,JunkMonster othMonster)
	 * is a static method of the class Monster. It takes 3 arguments one Barrel and two Monsters. and generates an eating proces.
	 * explicitely by invoking the overriden eat() method of each type of Monster's Class.
	 * Also it handles the exceptions thrown by the eat() method.
	 * It also has a randomizing mechanisem that decides which of the monsters will start to eat first in the barrel.*/
	public static  void drawAndEatItem(Barrel barr,HealthyMonster m1, JunkMonster m2){
		Random rd1=new Random();
		
		HealthyMonster Bar;
		JunkMonster Foo;
		Bar=m1;
		Foo=m2;
		int turn=rd1.nextInt(2);
		int monster;
		if(turn==0){//JunkMonster starts first.
		 monster=0;}
		else//HealthyMonster Starts first.
			{monster=1;}
		
		int i;
		
		for(i=0;i<=barr.getItemCount()-1;i++){
			
			//monster FOO
			if(monster==0){
				try{Foo.eat(barr.returnItem(i));}//end of try block
				catch(CannotEatException e){
					System.out.println(e.getMessage());
					//handling exception in case we get a Treat
					if (barr.returnItem(i) instanceof Treat){
					Treat temp=(Treat)barr.returnItem(i);
					temp.unWrapp();
					System.out.print("Status: "+temp.toString());
					System.out.println("\nNow I think this "+temp.getName()+" is Ready to be eaten!");}//end of if Treat
					//Handling exception in case we get a Pizza
					else if(barr.returnItem(i) instanceof Pizza){
						Pizza temp=(Pizza)barr.returnItem(i);
						temp.unBox();
						System.out.print("Status: "+temp.toString());
						System.out.println("\nNow I think this "+temp.getName()+" is Ready to be eaten!");
					}//end of if Pizza
					
				}//end of catch 1
				catch(DontLikeException e){
					System.out.println(e.getMessage());
				}//end of catch 2
				monster++;
			}//end of monster FOO's Turn to eat
			else if(monster==1){
				try{Bar.eat(barr.returnItem(i));}//end of try block
				catch(WillNotEatException e){
					System.out.println(e.getMessage());
				}//end of catch 1
				catch (CannotEatException e){
					System.out.println(e.getMessage());
					//Handling Exception in case we get a Pizza
					if(barr.returnItem(i) instanceof Pizza){
						Pizza temp=(Pizza)barr.returnItem(i);
						temp.unBox();
						System.out.print("Status: "+temp.toString());
						System.out.println("\nNow I think this "+temp.getName()+" is Ready to be eaten!");
					}//end of if Pizza
					//Handling exception in case we get a Fruit
					else if (barr.returnItem(i) instanceof Fruit){
						
						Fruit temp=(Fruit)barr.returnItem(i);
						temp.unPeel();
						System.out.print("Status: "+temp.toString());
						System.out.println("\nNow I think this "+temp.getName()+" is Ready to be eaten!");
						
					}//end of if Fruit
					
				}//end of catch2
				catch(DontLikeException e){
					System.out.println(e.getMessage());
				}//end of catch 3
				monster--;
			}//end of Monster bar turn to eat
		
		}//end of for loop
		
	}//end of draw and eat
	
	
	
	
	/**This is the toString method of the Monster Class, it returns the name of the Monster*/
	public String toString(){
		return " "+name+" ";
	}//end of class
	
	
	
}//end of monster class
