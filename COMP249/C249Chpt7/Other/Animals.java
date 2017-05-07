package Other;

public class Animals
{

	private String name;
	int age;
	protected int legs;//package access
	private final String Kingdom = "ANIMALS";
	
	public Animals()
	{
		name=null;
		legs=0;
		//ILLEGAL! Kingdom ="Crackers";
	}
	
	public Animals(String newnam,int nr)
	{
		name =newnam;
		legs =nr;
	}
	
	public int getLegs()
	{
		return legs;
	}
	
	String getName()
	{
		return name+" "+this.getKingdom();
	}
	
	private String getKingdom()
	{
		return Kingdom;
	}
	
	
	
}
