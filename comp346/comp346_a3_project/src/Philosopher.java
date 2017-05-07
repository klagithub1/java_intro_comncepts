import common.BaseThread;
/**
 * Class Philosopher.
 * Outlines main subroutines of our virtual philosopher.
 * @author Serguei A. Mokhov, mokhov@cs.concordia.ca
 * @updated KLAJDI KARANXHA 6173780, 31 march 2010
 */
public class Philosopher extends BaseThread
{
	
	//------------
	//Attributes
	//------------
	
	
	/**
	 * Max time an action can take (in milliseconds)
	 */
	public static final long TIME_TO_WASTE = 1000;//1 sec
	
	
	//------------
	//Methods
	//------------
	
	/**
	 * Default constructor, creates the thread object from BaseThread @see super()
	 * then sets the status by default to THINKING
	 * */
	public Philosopher()
	{
		super();
		
	}
	

	/**
	 * The act of eating.
	 * - Print the fact that a given phil (their TID) has started eating.
	 * - yield
	 * - Then sleep() for a random interval.
	 * - yield
	 * - The print that they are done eating.
	 */
	public void eat()
	{
		// Stating the initiation of eating process.
		System.out.println("Philosopher " + getTID() + " STARTED EATING.");
		try
		{
			yield();//Yielding
			sleep((long)(Math.random() * TIME_TO_WASTE));//Loosing Time
			yield();//Yielding
		}
		catch(InterruptedException e)
		{
			System.err.println("Philosopher.eat():");
			DiningPhilosophers.reportException(e);
			System.exit(1);
		}
		// Stating the ending of the eating process.
		System.out.println("Philosopher " + getTID() + " FINISHED EATING.");
	}

	/**
	 * The act of thinking.
	 * - Print the fact that a given phil (their TID) has started thinking.
	 * - yield
	 * - Then sleep() for a random interval.
	 * - yield
	 * - The print that they are done thinking.
	 */
	public void think()
	{
		//Stating the initiation of thinking.
		System.out.println("Philosopher "+getTID()+" STARTED THINKING.");
		try
		{
			yield();//Yielding
			sleep((long)(Math.random() * TIME_TO_WASTE));//Loosing Time
			yield();//Yielding
		}
		catch(InterruptedException e)
		{
			System.err.println("Philosopher.think():");
			DiningPhilosophers.reportException(e);
			System.exit(1);
		}
		//Stating the ending of thinking.
		System.out.println("Philosopher "+getTID()+" FINISHED THINKING.");
	}

	/**
	 * The act of talking.
	 * - Print the fact that a given phil (their TID) has started talking.
	 * - yield
	 * - Say something brilliant at random
	 * - yield
	 * - The print that they are done talking.
	 */
	public void talk()
	{	
			//Stating the initiation of talking.
			System.out.println("Philosopher "+getTID()+" STARTED TALKING.");
			yield();//Yielding
			saySomething();//Saying something at random.
			yield();//Yielding
			//Stating the ending of talking.
			System.out.println("Philosopher "+getTID()+" FINISHED TALKING.");
	}

	/**
	 * No, this is not the act of running, just the overridden Thread.run()
	 */
	public void run()
	{
		for(int i = 0; i < DiningPhilosophers.DINING_STEPS; i++)
		{
			//Declare the starting of the dining step.
			System.out.println("Philosopher " + getTID()+ " started Dining Step " + i);
			
			DiningPhilosophers.soMonitor.pickUp(getTID());

			eat();

			DiningPhilosophers.soMonitor.putDown(getTID());

			think();

			/*
			 * 
			 * A decision is made at random whether this particular
			 * philosopher is about to say something terribly useful.
			 * The probability a philosopher will say something is 1 out of 10,
			 * which is very rare.
			 */
//			((int)(Math.random()*10)) == 5
			if(true == false)
			{
				// Some monitor ops down here...
				talk();
				// ...
			}

			yield();
			//Declare the ending of the dining step.
			System.out.println("Philosopher " + getTID()+ " finished Dining Step " + i);
		}// for
		
	} // run()

	/**
	 * Prints out a phrase from the array of phrases at random.
	 * Feel free to add your own phrases.
	 */
	public void saySomething()
	{
		String[] astrPhrases =
		{
			"Eh, it's not easy to be a philosopher: eat, think, talk, eat...",
			"You know, true is false and false is true if you think of it",
			"2 + 2 = 5 for extremely large values of 2...",
			"If thee cannot speak, thee must be silent",
			"My number is " + getTID() + ""
		};

		System.out.println
		(
			"Philosopher " + getTID() + " says: " +
			astrPhrases[(int)(Math.random() * astrPhrases.length)]
		);
	}

}

// EOF
