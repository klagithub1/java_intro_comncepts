/*KLAJDI KARANXHA
 * 6173780
 * COMP249 Section U
 * Assignment 4
 * Provided HourlyEmployee class from Course Instructor.*/
import java.util.Scanner;

/**
 Class Invariant: All objects have a name string, hire date, nonnegative 
 wage rate, and nonnegative number of hours worked. A name string of 
 "No name" indicates no real name specified yet. A hire date of Jan 1, 1000 
 indicates no real hire date specified yet.
*/
public class HourlyEmployee extends Employee 
{
    private double wageRate; 
    private double hours; //for the month

    public HourlyEmployee( )
    {
        super( );
        wageRate = 0;
        hours = 0;
    }

    /**
     Precondition: Neither theName nor theDate is null; 
     theWageRate and theHours are nonnegative.
    */
    public HourlyEmployee(String theName, Date theDate,
                       double theWageRate, double theHours)
    {
         super(theName, theDate);
         if ((theWageRate >= 0) && (theHours >= 0))
         {
             wageRate = theWageRate;
             hours = theHours;
         }
         else
         {
             System.out.println(
                       "Fatal Error: creating an illegal hourly employee.");
             System.exit(0);
         }
    }

    public HourlyEmployee(HourlyEmployee originalObject)
    {
         super(originalObject);
         wageRate = originalObject.wageRate;
         hours = originalObject.hours;
    }
    	
    public HourlyEmployee(Employee originalObject)
    {
         super(originalObject);
         wageRate = 0.0;
         hours = 0.0;
    }
    	
    public double getRate( )
    {
        return wageRate;
    }

    public double getHours( )
    {
        return hours;
    }

    /**
     Returns the pay for the month.
    */
    public double getPay( )
    {
        return wageRate*hours;
    }

    /**
     Precondition: hoursWorked is nonnegative.
    */
    public void setHours(double hoursWorked)
    {
         if (hoursWorked >= 0)
             hours = hoursWorked;
         else
         {
             System.out.println("Fatal Error: Negative hours worked.");
             System.exit(0);
         }
     }

    /**
     Precondition: newWageRate is nonnegative.
    */
    public void setRate(double newWageRate)
    {
         if (newWageRate >= 0)
             wageRate = newWageRate;
         else
         {
             System.out.println("Fatal Error: Negative wage rate.");
             System.exit(0);
         }
    }

    public String toString( )
    {
        return (getName( ) + " " + getHireDate( ).toString( ) 
                + "\n$" + wageRate + " per hour for " + hours + " hours");
    }
 
    public boolean equals(HourlyEmployee other)
    {
       return (getName( ).equals(other.getName( )) 
                && getHireDate( ).equals(other.getHireDate( ))
                && wageRate == other.wageRate
                && hours == other.hours);
    }
    
    
    /***************************************************************************************************/
    							/*INHERITED INNER CLASS DEFINITION*/

    /*KLAJDI KARANXHA
     * 6173780
     * COMP249 Section U
     * Assignment 4
     * Provided original Date class from Course Instructor.*/

    public class Date extends Employee.Date
    {
        
        public Date( )
        {
            super();
        }

        public Date(int monthInt, int day, int year)
        {
            super(monthInt, day, year);
        }

        public Date(String monthString, int day, int year)
        {
            super(monthString, day, year);
        }

        public Date(int year)
        {
            super(year);
        }

        public Date(Date aDate)
        {
            if (aDate == null)//Not a real date.
            {
                 System.out.println("Fatal Error.");
                 System.exit(0);
            }

            setMonth(aDate.getMonth());
            setDay(aDate.getDay()) ;
            setYear(aDate.getYear());
        }

        public void setDate(int monthInt, int day, int year)
        {
            if (dateOK(monthInt, day, year))
            {
                this.setMonth(monthInt) ;
                this.setDay(day);
                this.setYear(year);
            }
            else
            {
                System.out.println("Fatal Error");
                System.exit(0);
            }
        }

        

        public void setDate(int year)
        {
            super.setDate(year);
        }

        public void setYear(int year)
        {
                super.setYear(year);
        }
        public void setMonth(int monthNumber)
        {
            	super.setMonth(monthNumber);
        }

        public void setDay(int day)
        {
            	super.setDay(day);
        }

        public int getMonth( )
        {
            return super.getMonth();
        }

        public int getDay( )
        {
            return super.getDay();
        }

        public int getYear( )
        {
            return super.getYear();
        }

        public String toString( )
        {
            return (getMonth() + " " + getDay()+ ", " + getYear());
        }

        public boolean equals(Date otherDate)
    	{
    	    
    	        return super.equals(otherDate);
        }

        public boolean precedes(Date otherDate)
        {
           return super.precedes(otherDate);
        }

        public void readInput( )
        {
            boolean tryAgain = true;
            Scanner keyboard = new Scanner(System.in);
            while (tryAgain)
            {
                System.out.println("Enter month, day, and year.");
                  System.out.println("Do not use a comma.");
                String monthInput = keyboard.next( );
                int dayInput = keyboard.nextInt( );
                int yearInput = keyboard.nextInt( );
                if (dateOK(monthInput, dayInput, yearInput) )
                {
                    setDate(monthInput, dayInput, yearInput);
                    tryAgain = false;
                }
                else
                    System.out.println("Illegal date. Reenter input.");
             }
        }

        private boolean dateOK(int monthInt, int dayInt, int yearInt)
        {
            return ( (monthInt >= 1) && (monthInt <= 12) &&
                     (dayInt >= 1) && (dayInt <= 31) &&
                     (yearInt >= 1000) && (yearInt <= 9999) );
        }

        private boolean dateOK(String monthString, int dayInt, int yearInt)
        {
            return ( monthOK(monthString) &&
                     (dayInt >= 1) && (dayInt <= 31) &&
                     (yearInt >= 1000) && (yearInt <= 9999) );
        }

        private boolean monthOK(String month)
        {
            return (month.equals("January") || month.equals("February") ||
                    month.equals("March") || month.equals("April") ||
                    month.equals("May") || month.equals("June") ||
                    month.equals("July") || month.equals("August") ||
                    month.equals("September") || month.equals("October") ||
                    month.equals("November") || month.equals("December") );
        }//end monthOK
  
    }//end Date class
   
}//end Hourly Employee
