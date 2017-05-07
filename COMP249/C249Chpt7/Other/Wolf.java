package Other;

public class Wolf extends Animals
{
private boolean hasHair;

public Wolf()
{
super("Wolf", 4);
hasHair=true;
}

public Wolf(String name,int legs,boolean hairstat)
{
	super(name,legs);
	hasHair=hairstat;
}

public int getLegs()
{System.out.println("Number of legs for this Wolfie: ");
	return legs;
}













}
