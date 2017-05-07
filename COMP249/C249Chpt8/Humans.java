
public abstract class Humans extends Object{
	
	
	//Instance Variables
	private String name;
	private int age;
	private String language;
	private double height;//in meters
	private char Sex;//Sex is M for male F for female and O for nothing
	//constructors
	public Humans() {
		name="anonymous";
		age=0;
		language="No Language Yet";
		height=10*Math.random();
		Sex='O';
	}
	
	public char showSex(){
		return Sex;
		
	}
	
	
	
	
	public abstract char getSex();
	
	public Humans(Humans h1){
		name=h1.name;
		language=h1.language;
		age=h1.age;
		height=h1.height;
		Sex = h1.getSex();
	}
	
	public void setSex(char set)
	{Sex=set;}
	
	
	
	
	
	
	

}
