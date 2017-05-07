/*KLAJDI KARANXHA
 * 6173780
 * COMP249 Section U
 * Assignment 4*/
import java.util.Scanner;
public class TestDriver 
{

	/**TestingDriver tests the efficiency of the modified provided classes:
	 * 1.Employee
	 * 2.HourlyEmployee
	 * 3.Date
	 * In this driver the following are tested:
	 * a.class Date works correctly for Employee and HourlyEmployee after we implemented it as an inner class.
	 * b.we can create date objects for both inner classes.
	 * c. we can use accessor and mutator methods of both inner classes(Date and the Extended Date.
	 * d.we can create objects and use methods of Employee and Hourly Employee after the modifications done.)*/
	public static void main(String[] args) 
	{
		//Opening Messages
		System.out.println("\nWelcome to my Testing Program.\nThe aim of this driver is to test the efficiency " +
				"of the following classes:\n" +
				"1. Employee\n" +
				"2. HourlyEmployee\n" +
				"3.(Inner Classes) Date( of these above mentioned classes.)\n");
		System.out.println("\n\t\t-------------------------------------------------------\t\t");
		System.out.println("\nPART 1 - Testing Employees.");
							/*PART 1 - Testing all the Employees*/
		
		//create an array of 10 employees
		Employee[] ENCS=new Employee[10];
		int i;
		//initialize 5 Employees to default
		for(i=0;i<=ENCS.length-4;i++)
		{ENCS[i]=new Employee();				
			
		}//end for
		
		//personalizing  the  5 Employees
		Employee.Date[] date=new Employee.Date[ENCS.length-5];		
		int j;
		for(j=0;j<=ENCS.length-6;j++)
		{date[j]=ENCS[j].new Date();			
		}//end for
		
		
		//setting the names of theses 5 employees
		ENCS[0].setName("Alain Masters");
		ENCS[1].setName("Kostas Kliamenakis");		
		ENCS[2].setName("Francesco Bettucini");			
		ENCS[3].setName("Emilian Voyovich");					
		ENCS[4].setName("Ginette Morin");							
		
		//setting the dates of theses 5 employees
		date[0].setMonth(7);					
		date[0].setDay(27);						
		date[0].setYear(2003);					
		date[1].setDate(2005);					
		date[2].setDate(9, 2, 2001);		
		date[3].setDate("March", 8, 1995);		
		date[4].setDate(10,31,2000);		
		
		ENCS[0].setHireDate(date[0]);			
		ENCS[1].setHireDate(date[1]);			
		ENCS[2].setHireDate(date[2]);			
		ENCS[3].setHireDate(date[3]);			
		ENCS[4].setHireDate(date[4]);		
		
		//initializing 2 other  employees 

		Employee.Date date_5=ENCS[5].new Date("February",5,2001);		
		Employee.Date date_6=ENCS[6].new Date(1993);					
		ENCS[5].setHireDate(date_5);									
		ENCS[6].setHireDate(date_6);									
		ENCS[5].setName("Elisa Oxa");									
		ENCS[6].setName("Hose Ruerta");									
		//Display the current list of the Employees
		System.out.println("\n\t\t-------------------------------------------------------\t\t");
		System.out.println("Here is the current list of all the employees:\n");
		int m;
		//creating a display loop
		for(m=0;m<=ENCS.length-4;m++)
		{
			System.out.println(ENCS[m].toString());
		}
		//User inputs the names and Hire Dates of three other Employees
		ENCS[7]= new Employee();
		ENCS[8]= new Employee();
		ENCS[9]= new Employee();
		System.out.println("Please enter the names of three employees and press Enter after each input:\n ");
		Scanner input=new Scanner(System.in);
		String name7=input.nextLine();
		String name8=input.nextLine();
		String name9=input.nextLine();
		
		//create three dates for the employees
		Employee.Date date_7=ENCS[7].new Date();
		Employee.Date date_8=ENCS[8].new Date();
		Employee.Date date_9=ENCS[7].new Date();
		System.out.println("Please enter the hire dates of three employees as indicated: \n");
		date_7.readInput();
		ENCS[7].setName(name7);
		ENCS[7].setHireDate(date_7);
		date_8.readInput();
		ENCS[8].setName(name8);
		ENCS[8].setHireDate(date_8);
		date_9.readInput();
		ENCS[9].setName(name9);
		ENCS[9].setHireDate(date_9);	
		int k;
		//dislpay the list of all the employees
		System.out.println("Here is the refreshed list of all the employees after modifications:\n");
		for(k=0;k<=ENCS.length-1;k++)
		{
			System.out.println(ENCS[k].toString());
		}
			
						/*PART 2- Test the Hourly Employees*/
		System.out.println("\n\t\t-------------------------------------------------------\t\t");
		System.out.println("\n\t\t-------------------------------------------------------\t\t");
			System.out.println("PART 2 - HourlyEmployees.\n");
			
		//Creating an array of 10 Hourly employees:
		HourlyEmployee[] HENCS=new HourlyEmployee[10];
		//Converting the first five Employees to Hourly Employee
		int o;
		
		for(o=0;o<=HENCS.length-6; o++)
		{
			HENCS[o]=new HourlyEmployee(ENCS[o]);
		}
		//reset counter
		o=0;	
		//setting these Employees wageRate to 27.75CAD/hour
		double minimumWageRate=27.75;
		for(o=0;o<=HENCS.length-6;o++)
		{
			HENCS[o].setRate(minimumWageRate);
		}	
		//reset counter
		o=0;
		//setting these Employees minimum Weekly Hours
		double FullTimeRegularHours=40;
		for(o=0;o<=HENCS.length-6;o++)
		{
			HENCS[o].setHours(FullTimeRegularHours);
		}	
			
		//Display the current list of Hourly Employees:
		//reset counter
		o=0;
		System.out.println("\nThis is the Current list of Hourly Employees:\n");
		for(o=0;o<=HENCS.length-6;o++)
		{
			System.out.println(HENCS[o].toString());
		}	
		
		
		/*Prompt user to create the other 5 Hourly Employees*/
		
		
		//Create 5 Wagerates
		//Create 5 WeekHours
		//Create 5 name Strings
		double []hrate=new double[5];
		double []week_reg_hrs=new double[5];
		String[]hname =new String[5];
		//Create 5 Default HourlyEmployees
		//increase counter
		o++;
		for(o=5;o<=HENCS.length-1;o++)
		{
			HENCS[o]=new HourlyEmployee();
		}
		//Reset Counter
		o=5;
		//Display Message Prompt user for names
		System.out.println("Please Enter the Names of five Hourly Employees:\n");
		int c;
		for(c=0;c<=hname.length-1;c++)
		{
			hname[c]=input.nextLine();
		}
		//reset counter
		c=0;	
		//Prompt User for Weekly Hours
		System.out.println("Please Enter the Regular Weekly Hours of five HourlyEmployees:\n");
		for(c=0;c<=week_reg_hrs.length-1;c++)
		{
			week_reg_hrs[c]=input.nextDouble();
		}
		//reset counter
		c=0;	
		//Prompt User for Weekly Pay per Hour
		System.out.println("Please Enter the Hourly Wage Rate of five HourlyEmployees:\n");
		for(c=0;c<=hrate.length-1;c++)
		{
			hrate[c]=input.nextDouble();
		}
		//reset counter
		c=0;		
		
		//Applying modifications to our default Employees.
		for(c=0;c<=hrate.length-1;c++)
		{//Setting Week Hours, Rates and names
			for(o=5;o<=HENCS.length-1;o++)
			{
			HENCS[o].setHours(week_reg_hrs[c]);
			HENCS[o].setRate(hrate[c]);
			HENCS[o].setName(hname[c]);
			}
		}
		//reset counters
		o=5;
		c=0;
		//Creating 5 Date Objects for type HourlyEmployee.
		HourlyEmployee.Date[] hdate=new HourlyEmployee.Date[5];
		//Initiating Date objects to Default
		for(c=0;c<=hdate.length-1;c++)
		{
			for(o=5;o<=HENCS.length-1;o++)
			{
				hdate[c]=HENCS[o].new Date();
			}
		}
		//resetting counters
		o=5;
		c=0;
		//Prompt The user to set the Hire Dates for hourly Employees
		System.out.println("Please Enter the Hire Dates as indicated:\n");
		for(c=0;c<=hdate.length-1;c++)
		{
			hdate[c].readInput();
		}
		//reset counter
		c=0;
		//Setting the Dates
		for(c=0;c<=hdate.length-1;c++)
		{	for(o=5;o<=HENCS.length-1;o++)
			{
			HENCS[o].setHireDate(hdate[c]);
			}
		}
		//Display Final Table of Hourly Employees and their Respective Pays
		//Display Message
		System.out.println("\n\t\t-------------------------------------------------------\t\t");
		System.out.println("This is the Refreshed Table after the added Hourly Employees:\n");
		for(o=0;o<=HENCS.length-1;o++)
		{
			System.out.println(HENCS[o].toString()+" Respective Standard Bi-Weekly paycheque:"+2*HENCS[o].getPay()+" CAD");
		}
		//Closing program
		System.out.println("\t\t-------------------------------------------------------\t\t");
		System.out.println("\t\tThank You for taking time to test my Program!\t\t");
	}//end main

}//end TestDriver
