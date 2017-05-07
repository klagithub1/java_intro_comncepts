//--------------------------------------------
//Assignment 1
//Part 2
//Written by: Klajdi Karanxha 6173780
//For COMP 249 Section UA
//--------------------------------------------

import java.util.Scanner;


public class Polynomial_Driver {

	
	public static void main(String[] args) {
		
	/**This is a driver program that I will use to test my polynomial class that I have created
	 * the driver will perform the following:
	 * create an array of 8 polynomials
	 * prompt for the coefficients of the first two polynomials
	 * randomly generate the coefficients of the other three polynomial objects
	 * in location 5 store the content of sum of polynomial0 and 2
	 * in location6 stroetriple the polynomial in location 1
	 * in location7 store the derivative of the polynomial 4
	 * prompt for a value x and solve the polynomial for that value
	 * and finally print the 8 polynomials*/
		
	//First I will create my introducing and hello message.
		String s="Klajdi Karanxha (6173780).\n" +
				"COMP 249 Section UA.\n" +
				"Assignment 1 - Driver Program\n\n" +
				"***\tPOLYNOMIAL TEST DRIVE\t ***";
		
		System.out.println(s);
		System.out.println("________________________________________________________");
		
		//First we create our polynomial array
		polynomial[] array = new polynomial[8];
		
		//Secondly we gonna initialize our objects.
		Scanner kb1=new Scanner(System.in);
		
		//creating an array of doubles as user inputs.
		double[] input=new double[10];
		
		//create the user message
		System.out.println("Please enter 5 float point numbers as coefficients for the first polynomial.\n" +
				"coefficients are consequently from power of 0 to the power of 4. Press ENTER after each entry:")	;	
		input[0]=kb1.nextDouble();
		input[1]=kb1.nextDouble();
		input[2]=kb1.nextDouble();
		input[3]=kb1.nextDouble();
		input[4]=kb1.nextDouble();
		System.out.println("Creating first Polynomial ...");
		array[0]= new polynomial(input[0],input[1],input[2],input[3],input[4]);
		System.out.println("");
		System.out.println("Please enter 5 float point numbers as coefficients for the second polynomial.\n" +
				"coefficients are consequently from power of 0 to the power of 4. Press ENTER after each entry:");
		input[5]=kb1.nextDouble();
		input[6]=kb1.nextDouble();
		input[7]=kb1.nextDouble();
		input[8]=kb1.nextDouble();
		input[9]=kb1.nextDouble();
		System.out.println("Creating second Polynomial ...");
		array[1]= new polynomial(input[5],input[6],input[7],input[8],input[9]);
		System.out.println("");
		System.out.println("Creating three other Polynomials (randomly generated) ...");
		//Now we randomly generate the coefficients for the next three polynomials
		
		
		//Create an array of 15 inputs doubles for the three polynomials
		double[] inputs2 = new double[15];
		int b;
		for(b=0;b<=inputs2.length-1;b++)
		{
		inputs2[b]=100.00*Math.random();}
		//Create Polynomial 2
		System.out.println("Creating the third polynomial ...");
		array[2]=new polynomial(inputs2[0],inputs2[1],inputs2[2],inputs2[3],inputs2[4]);
		
		
		System.out.println("");
		
		//Create Polynomial 3, or the fourth polynomial.
		System.out.println("Creating the fourth polynomial ...");
		array[3]=new polynomial(inputs2[5],inputs2[6],inputs2[7],inputs2[8],inputs2[9]);
		System.out.println("");

		//		Create Polynomial 4, or the fifth polynomial.
		System.out.println("Creating the fifth polynomial ...");
		array[4]=new polynomial(inputs2[10],inputs2[11],inputs2[12],inputs2[13],inputs2[14]);
		System.out.println("");
		
		//In  location 5 we store the sum of the first and the third
		System.out.println("Adding the two polynomials ...");
		array[5]=new polynomial(array[0].addPolynomial(array[2]));
		System.out.println("");
		
		//In  location 6 we are going to create a polynomial which is the triple
		//of the one in location 1.
		System.out.println("Multiplying Polynomial ...");
		array[6]=new polynomial(array[1].multiplyPolynomial(3));
		System.out.println("");
		
		//In the last location, location7 we are going to store the derivative of the polynomial
		//that is in location 4
		System.out.println("Deriving Polynomial ...");
		array[7]=new polynomial(array[4].derivePolynomial());
		System.out.println("");
		
		//Now we are going to promt the user for a value X
		//that will be used as a solution for the polynomial so 
		//that we can find the values of the polynomials at that given point X.
		
		System.out.println("Please enter a value to replace X: ");
		double X_input;
		X_input=kb1.nextDouble();
		
		//Now we first print the 8 Polynomials that we've created:
		
		System.out.println("Here are the 8 polynomials that we have created:");
		System.out.println("-----------------------------------------------------------");
		int h;
		for(h=0;h<=array.length-1;h++)
		{System.out.println(array[h].toString());
		
		System.out.println("");}
		System.out.println("-----------------------------------------------------------");
		
		
		//Now I will reprint them using another method in order to cut the excessive decimal numbers.
		
		System.out.println("");
		System.out.println("Here are the same Polynomials displayed in another way.\n" +
				"(Perhaps more user friendly!) : ");
		System.out.println("-----------------------------------------------------------");
		System.out.println("");
		int u;
		for(u=0;u<=array.length-1;u++)
		{array[u].showPolynomial();}
		System.out.println("");
		System.out.println("-------------------------------------------------------------");
		System.out.println("");
		
		//Now we use the method that displays the non-zero terms in an array form.
		
		System.out.println("Here is the list of the non-zero coefficients of the polynomials:\n" +
				" ");
		System.out.println("-------------------------------------------------------------");
		System.out.println("");
		int o,p;
		for(o=0;o<=array.length-1;o++)
		{for(p=0;p<=array[o].numberOfTerms().length-1;p++)
		{System.out.printf("%4.2f ",array[o].numberOfTerms()[p]);}
		System.out.println();}
		System.out.println();
		System.out.println("-------------------------------------------------------------");
		System.out.println();
		
		//Now we evaluate the polynomial at the value the user entered few moments ago.
		System.out.println("Also, each polynomial evaluated at the point  X = "+X_input+" has the following value:");
		System.out.println("-------------------------------------------------------------");
		System.out.println();
		
		int w;
		for(w=0;w<=array.length-1;w++)
		{System.out.println(array[w].evaluatePolynomial(X_input));}
		System.out.println("-------------------------------------------------------------");
		//Now we Integrate all the polynomials
		System.out.println();
		
		
		System.out.println("Here is the result of the integration of all the polynomials: ");
		System.out.println("-------------------------------------------------------------");
		System.out.println();
		int r;
		for(r=0;r<=array.length-1;r++)
		{array[r].integratePolynomial();
		System.out.println();}
		System.out.println();
		System.out.println("-------------------------------------------------------------");
		System.out.println("-------------------------------------------------------------");
		System.out.println("-------------------------------------------------------------");
		System.out.println("END OF PROGRAM.\nThank You for testing my Program!");
		System.out.println();
		System.out.println("*******\t\tKLAJDI KARANXHA.   Concordia University, 2009\t\t*******");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
