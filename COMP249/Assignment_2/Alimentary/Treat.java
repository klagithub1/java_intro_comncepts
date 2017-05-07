//--------------------------------------------
//Assignment 2
//Written by: Klajdi Karanxha 6173780
//For COMP 249 Section UA
//--------------------------------------------
package Alimentary;

public class Treat extends Food{
//Instance Variables

	private boolean hasWrapping;
	
	//Methods and constructors
	/**This is the Constructor that takes a String and a boolean value as an argument*/
	public Treat(String name, boolean b) {
	
		super(name);
		hasWrapping=b;
		
		
		
	}//end of constructor

	
	/**This is the isReadyToEat() method Overriden from Food parent that shows if a treat has wrapping.*/
	public boolean isReadytoEat(){
		if(this.hasWrapping==true)
		{System.out.println("This Treat is not ready to eat, should be unWrapped first!");
		return false;}
		else
			return true;
	}//end of isReadyToEat
	
	/**This methods changes the boolean value hasWrapping to false*/
	public void unWrapp(){
		
		if (this.hasWrapping==true)
		{this.hasWrapping=false;}
		else
			System.out.println("This item is already unWrapped!");
	}//end of unWrapp
	
	/**This is the Overriden Inherited removeCover() method*/
	public void removeCover()
	{this.foodcover=false;
	}//end of removeCover
	
	/**This is the toString method for Treat Class*/
	public String toString()
	{
		String s1;
		if (this.hasWrapping==true)
	{s1="Wrapped!";}
	else
		s1="Unwrapped!";
		return "The following item is a: "+this.getClass()+ " "+this.name+" and it is "+s1;
	}//end of toString
	
	
	

	
}//end of Treat Class
