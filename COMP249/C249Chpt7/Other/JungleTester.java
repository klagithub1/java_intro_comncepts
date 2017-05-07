package Other;

public class JungleTester
{

	public static void main(String[] args)
	{
		Animals Wolf1=new Wolf();
		//ILLEGAL! UPCASTING not allowed: 
		//Wolf rudolph = new Animals();
		
		Wolf1.legs=6;//becaus legs is protected!
		
	}
	
	
	
}
