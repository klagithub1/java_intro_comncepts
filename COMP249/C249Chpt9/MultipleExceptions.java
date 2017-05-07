public class MultipleExceptions {
  public static void main (String[] args) 	
  { 	
  	try {
		String a = "0";
		int r2 = Integer.parseInt(a) / Integer.parseInt(a);
	} 
	catch (ArithmeticException e) {
		System.out.println("Calculation Error");
	} 
	catch (Exception e) {
		System.out.println("General Exception");
	} 
	finally {
		System.out.println("Finally");
	}
	System.out.println("Finished");
  }
} 