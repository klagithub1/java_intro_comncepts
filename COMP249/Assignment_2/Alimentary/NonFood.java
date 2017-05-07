//--------------------------------------------
//Assignment 2
//Written by: Klajdi Karanxha 6173780
//For COMP 249 Section UA
//--------------------------------------------
package Alimentary;

public class NonFood extends BarrelItem{

	
	//CONSTRUCTORS
	/**The constructor calls the superconstructor of BarrelItem and creates a NonFood by setting a name for it.*/
	public NonFood(String nam){
		super();
		setName(nam);
		
	}//end of constructor
	
	
	/**This is the toString method of the NonFood Class*/
	public String toString(){
		
		return "This is a :"+this.getClass()+" Item, precisely a "+this.name;
		
	}//end of toString
	
	
}//end of class
