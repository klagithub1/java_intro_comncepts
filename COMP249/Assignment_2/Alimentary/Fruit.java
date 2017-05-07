//--------------------------------------------
//Assignment 2
//Written by: Klajdi Karanxha 6173780
//For COMP 249 Section UA
//--------------------------------------------
package Alimentary;

public class Fruit extends Food{
	
	//instance variables
	private boolean isPeeled;
	
/**This is the fruit constructor that takes 2 arguments and defines a fruit object. */
	public Fruit(String string, boolean b) {
		
		super(string);
		this.isPeeled=b;
		
		
	}//end of constructor

	/**This Method checks if a fruit has peel and defines if it is ready to eat or not.*/
	public boolean isReadyToEat(){
		
		if(this.isPeeled==true)
		{System.out.println("This fruit is not ready to eat. Please unpeel.");
		
		return false;
		
			
		}//end of if conditional.
		else 
			
			return true;
		
		
	}//end of isreadytoeat
	/**For all fruits the cover has to be removed befor they're eaten.*/
	public void removeCover(){
		
		this.foodcover=false;
		
	}//end of removeCover
	/**unPeel method of fruit class that removes the peel of a fruit*/
	 public void unPeel(){
		 if(this.isPeeled==true)
		 {this.isPeeled=false;}//end of if.
		 else
			 System.out.println("This Fruit is already peeled");
		 
	 }//end of unPeel
	
	/**toString method of Fruit Class*/
	public String toString(){
		String s1;
		if (this.isPeeled==true)
		{s1="It is Peeled";
		}
		else
		s1="It is not Peeled, just remove the cover before eating!";
		
		return "The following is a: "+this.getClass()+" "+this.name+" and "+s1;}
	
	
	
	
	
	
}//end of class
