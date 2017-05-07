//--------------------------------------------
//Assignment 2
//Written by: Klajdi Karanxha 6173780
//For COMP 249 Section UA
//--------------------------------------------
package Alimentary;

public class Pizza extends Food{
	//ATTRIBUTES
private boolean isInBox;

/**The constructor takes a String and a boolean value as an argument and creates a Pizza Object*/
	public Pizza(String string, boolean b) {
	
		super(string);
		this.isInBox=b;
		
		
	}//end of constructor

	/**This method checks if pizza is Boxed and returns a boolean value to declare if it is ready to be eaten or not
	 * It is Overriden in Child Classes of Food*/
	public boolean isReadyToEat(){
		if(this.isInBox==true)
		{return false;}
		else
			return true;
	}//end of OVERRIDEN method
	
	/**Unbox method makes the boolean value of isIn Box false*
	 
	 */
	public void unBox(){
		if (this.isInBox==true)
			this.isInBox=false;
		else
			System.out.println("This item is already unBoxed");
	}//end ofunBox
	
	/**This  method removes the cover of the pizza if it is unBoxed so you can eat it.*/
	
	public void removeCover(){
		this.foodcover=false;
	}//end of removeCover
	
	/**ToString method of Pizza Objects*/
	public String toString()
	{String s1;
		if(this.isInBox==true)
	{s1="in a Box!";}
	else
	{s1="unboxed!";}
		
		return "This is a: "+this.getClass()+" "+this.name+" item and it is: "+s1;
	}//end of toString
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}//end of Pizza class
