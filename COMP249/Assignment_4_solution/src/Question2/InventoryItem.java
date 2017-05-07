/*KLAJDI KARANXHA
     * 6173780
     * COMP249 Section U
     * Assignment 4*/
package Question2;
/**InventoryItem implements Comparable Interface so a CompareTo() method is implemented in the class,
 * all class objects are a Total-Order.*/
public class InventoryItem implements Comparable
{
	//Class variables
	private String name;
	private int uniqueItemID;
	
			/*Class methods*/
	
	//Constructors
	/**Default constructor initiates the String to "unnamed_item" and the ID to 0*/
	public InventoryItem()
	{
		name="unnamed_item";
		uniqueItemID=0;
	}
	/**Constructor takes two arguments (String, int) and initiates respectively the variables.*/
	public InventoryItem(String name, int id)
	{
		this.name=name;
		uniqueItemID=id;
	}
	
	//accessor methods
	/**This method returns an integer equal to uniqueItemID variable.*/
	public int getID()
	{
		return uniqueItemID;
	}
	/**returns a String with Item name*/
	public String getName()
	{
		return name;
	}
	
	//mutator methods
	/**Takes an int as an arguments and modifies the instance variable uniqueItemID*/
	public void setID(int id)
	{
		this.uniqueItemID=id;
	}
	
	/**takes a String argument and sets the name instance variable*/
	public void setName(String new_name)
	{
		this.name=new_name;
	}
	
	//to string method
	public String toString()
	{
		return "Name: "+name+" Item ID: "+uniqueItemID;
	}

	//Comparison method
	/**CompareTo() method defines a total order in class variable set and returs an integer:
	 * 1 when calling object comes after the argument object
	 * 0 when they are at the same level or euqal
	 * -1 when calling object precedes the argument*/
	public int compareTo(Object o) 
	{
		//a value of type int which will be returned
		int returned;
		//a temporary InventoryItem object;
		InventoryItem temporary;
			//Cast o and make temporar equal to it.
		
			temporary=(InventoryItem) o;
			if(this.uniqueItemID > temporary.uniqueItemID)
			{
				returned=1;
				return returned;
			}
			
			else if(this.uniqueItemID == temporary.uniqueItemID)
			{
				returned =0;
				return returned;
			}
			
			else
				returned =-1;
				return returned;
		
	}//end of compareTo

}//end of class
