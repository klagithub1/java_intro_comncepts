//--------------------------------------------
//Assignment 2
//Written by: Klajdi Karanxha 6173780
//For COMP 249 Section UA
//--------------------------------------------
package Alimentary;

public class BarrelItem {
	//attributes
	/**name of the item is protected from other classes that are outside the hierarchy.*/
	protected String name;
	
	//CONSTRUCTORS
	
	/**The default constructor creates one Barrel Item for the  barrel with a null name.*/
	public BarrelItem() {
		name=null;
		}//end of default constructor
	
	/** The mutator method set name changes the name of the barrel Item*/
	public void setName(String newname)
	{name=newname;
	
	}//end of setname

	/**The accessor method returns the name of the calling object*/
	public String getName(){
		return name;
	}//end of getName()
	
	/**This is the method toString of barrelItem Class.It displays the class and the name*/
public String toString()
{return "This item is from the class: "+this.getClass()+" and its name is:"+this.name;}//end of toString

}//end of class BarrelItem
