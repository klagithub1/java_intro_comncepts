//--------------------------------------------
//Assignment 2
//Written by: Klajdi Karanxha 6173780
//For COMP 249 Section UA
//--------------------------------------------
package Alimentary;

public abstract class Food extends BarrelItem{
	/**every food item is Covered, Monsters should remove cover before eating the food.*/
	protected boolean foodcover=true;
	
	/**This is the Food Constructor*/
	public Food(String name)
	{super();
	setName(name);
	}//end of constructor

	
	/**This is our abstract method that will be overriden in the later methods*/
	public abstract void removeCover();
	
	/**This method takes a food, either a Pizza, Treat or Fruit and then makes it ready to be eaten.*/
	public void prepare(){
		removeCover();
		
		System.out.println("Cover is removed! Now the  food is Ready to be eaten!");
		
	}//end of prepare()
	
	
	
	
	/**This is the toString method of the Food abstract class*/
	public String toString(){
		
		return "This is a Food item!";
	}//end of toString
	/**This method displays if food is covered or not.*/
	public boolean HasCover(){return foodcover;}
	
	
}//end of Food Class
