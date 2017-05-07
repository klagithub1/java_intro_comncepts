//--------------------------------------------
//Assignment 1
//Part 1
//Written by: Klajdi Karanxha 6173780
//For COMP 249 Section UA
//--------------------------------------------


public class polynomial 
{
	/**This is the only instance variable of the class,
	 *  an array of doubles that represent the powers of X*/
	private double[] powers=new double[5];

//Now we  create our constructors
	
	/**The first constructor is the default one.*/
	public polynomial()
	{	int q;
		for(q=0;q<=powers.length-1; q++)
			{powers[q]=0.00;}
	}
		
/**The second constructor overloaded  takes five doubles as parameters*/

	public polynomial(double d0,double d1,double d2,double d3,double d4)
	{
		powers[0]=d0;
		powers[1]=d1;
		powers[2]=d2;
		powers[3]=d3;
		powers[4]=d4;
	}

/**This is a copy constructor that takes a polynomial objects and
 * creates another one same to the first copy*/
	public polynomial(polynomial p1)
	{	int k;
		for(k=0;k<=powers.length-1;k++)
		{this.powers[k]=p1.powers[k];}
	}

//Accessing Methods
public double[] getPolynomial()
{double[]temp1=new double[5];
int j;
for (j=0;j<=powers.length-1;j++)
{temp1[j]=powers[j];}
return temp1;}
/**This method displays the polynomial on the screen*/
public void showPolynomial()
{System.out.printf( "(%.2f*X^4) + (%.2f*X^3) + (%.2f*X^2) + (%.2f*X) + (%.2f)",powers[4],powers[3],powers[2],powers[1],powers[0]);

System.out.println();}

/**The following method displays the Degree of the  polynomial */
public void showDegree()
{int k1;
for(k1=powers.length-1;k1>=0;k1--)
{if(powers[k1]>0)
	{System.out.println("The Polynomial is of degree: "+k1);
	break;}
}}


//Mutator methods


/**This method changes one of the double coefficients before a defined power of X*/
public void setCoefficient(int pwr,double nwcf)
{	if(pwr==0)
	{powers[pwr]=nwcf;}
	else if (pwr==1)
	{powers[pwr]=nwcf;}
	else if (pwr==2)
	{powers[pwr]=nwcf;}
	else if (pwr==3)
	{powers[pwr]=nwcf;}
	else if (pwr==4)
	{powers[pwr]=nwcf;}
	else if (pwr>4||pwr<0)
	{System.out.println("ERROR in defining the powers of X !\nPowers of X should be between 0 and 4\n Operation not performed!");}
}
/**This method choses one of the powers of X and makes the coefficient before it equal to 0*/
public void resetCoefficient(int pw)
{if(pw==0)
{powers[pw]=0.00;}
else if (pw==1)
{powers[pw]=0.00;}
else if (pw==2)
{powers[pw]=0.00;}
else if (pw==3)
{powers[pw]=0.00;}
else if (pw==4)
{powers[pw]=0.00;}
else if (pw>4||pw<0)
{System.out.println("ERROR in defining the powers of X !\nPowers of X should be between 0 and 4\n Operation not performed!");}}


//The Adding method
/**This method adds the coefficents before the powers of X of one polynomial to the other and return a new polynomial.*/

public polynomial addPolynomial(polynomial pol)
{polynomial tempi=new polynomial();
int h;
for(h=0;h<=powers.length-1;h++)
	{tempi.powers[h]=this.powers[h]+pol.powers[h];}
return tempi;
}

//The evaluate method
/**This method takes a double value as an argument and evaluates the polynomial at that given value
 * and it returns the result of the evaluation.*/
public double evaluatePolynomial(double x)
{double result;
result=powers[0]+(powers[1]*x)+(powers[2]*x*x)+(powers[3]*x*x*x)+(powers[4]*x*x*x*x);
	
	
	return result;}
//the derivative method
/**The Derivative method computes the derivative of a polynomial and returns the derivative.*/
public polynomial derivePolynomial()
{polynomial temp = new polynomial();

int j,i;
for(j=0;j<=powers.length-1;j++)
{temp.powers[j]=0;}

for(i=0;i<=powers.length-2;i++)
{temp.powers[i]=(i+1)*(this.powers[i+1]);}


return temp;}

//The integrate method
/**This method takes a polynomial, computes its integral and returns the integrated polynomial.*/
public polynomial integratePolynomial()
{polynomial tmp=new polynomial();

int i;
for(i=0;i<=powers.length-1;i++)
{if(this.powers[i]==0)
		{tmp.powers[i]=0;}
else
	tmp.powers[i]=this.powers[i]/(i+1);
}

System.out.printf( "(%.2f*X^5) + (%.2f*X^4) + (%.2f*X^3) + (%.2f*X^2) + (%.2f*X) + Const. ",tmp.powers[4],tmp.powers[3],tmp.powers[2],tmp.powers[1],tmp.powers[0]);

	return tmp;}





//Number of terms method
/**this method  analyzes a polynomial and returns the non-zero terms of it
 *  in the form of an array of doubles*/
public double[] numberOfTerms()
{double[] returns=new double[5];
int i,j,k;
for(j=0;j<=powers.length-1;j++)
{returns[j]=0;}

int counter = 0,ret_track=0;
for(i=0;i<=powers.length-1;i++)
{		if(powers[i]!=0)
			{returns[ret_track]=powers[i];
			ret_track++;
			counter++;}
}
double[] returns2=new double[counter];
for(k=0;k<=counter-1;k++)
{returns2[k]=returns[k];}
return returns2;
}
//The multiplying method
/**This method takes an integer between 1 and 99, 
 * and  multiplies the polynomial`s coefficients with that integer.*/

public polynomial multiplyPolynomial(int rd)
{polynomial temp=new polynomial();
while(rd>=100||rd<=0)
{System.out.println("Error in resolving the multiplying coefficient! \n" +
		"Please verify that the coefficient is between 1 and 99.");
	}

int i;
		for(i=0;i<=powers.length-1;i++)
		{temp.powers[i]=rd*this.powers[i];}

return temp;


}



//The toString method of polynomial class

/**This is the toString method that displays  a polynomial in a string form.*/


public String toString()
{return " "+powers[0]+" + ("+powers[1]+"*X)+("+powers[2]+"*X^2)+("+powers[3]+"*X^3)+("+powers[4]+"*X^4)";
}



}
