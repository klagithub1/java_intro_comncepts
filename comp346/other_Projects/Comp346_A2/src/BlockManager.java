// Import (aka include) some stuff.
import common.*;
/*
 * KLAJDI KARANXHA 6173780
 * COMP 346 Assignment 2
 * Source Code file for Question 3 and 4.
 * */

/**
 * Class BlockManager
 * Implements character block "manager" and does twists with threads.
 *
 * @author Serguei A. Mokhov, mokhov@cs.concordia.ca;
 * Inspired by previous code by Prof. D. Probst
 *
 * $Revision: 1.2 $
 * $Last Revision Date: 2009/02/04 $
 */
public class BlockManager
{
	/**
	 * The stack itself
	 */
	private static BlockStack soStack = new BlockStack();

	/**
	 * Number of threads dumping stack
	 */
	private static final int NUM_PROBERS = 3;

	/**
	 * Number of steps they take
	 */
	private static int siThreadSteps = 5;

	/**
	 * For atomicity
         * The mutex semaphore will preserve the atomicity of stack operations.
         * The stack is considered as a Critical Section. Accessing and modifying
         * the stack should be atomic operations.
	 */
       //Mutex semaphore is initialized to 1.
	private static Semaphore mutex = new Semaphore(1);

	/*
	 * For synchronization
	 */

	/**
	 * s1 is to make sure phase I for all is done before any phase II begins.
	 * Although it is not recommended to initialise a negative semaphore,
	 * The reason I did do was to save the creation of 7 semaphores in order to throw 7 signals.
	 * My approach is to create one semaphore and initialise it to a negative value and then it is being incremented each time it signals.
	 */
	/*Initialised to -6 because we have 7 threads and we need all of them to signal completion of Phase I before going 
	to Phase II.*/
	private static Semaphore s1 = new Semaphore(-6);
	

	/**
	 * s2 is for use in conjunction with Thread.turnTestAndSet() for phase II proceed
	 * in the thread creation order
	 */


	// The main()
	
	public static void main(String[] argv)
	{
		try
		{
			// Some initial stats...
			System.out.println("Main thread starts executing.");
			System.out.println("Initial value of top = " + soStack.getTop() + ".");
			System.out.println("Initial value of stack top = " + soStack.pick() + ".");
			System.out.println("Main thread will now fork several threads.");

			/*
			 * The birth of threads
			 */
			AcquireBlock ab1 = new AcquireBlock();
			AcquireBlock ab2 = new AcquireBlock();

			System.out.println("main(): Two AcquireBlock threads have been created.");

			ReleaseBlock rb1 = new ReleaseBlock();
			ReleaseBlock rb2 = new ReleaseBlock();

			System.out.println("main(): Two ReleaseBlock threads have been created.");

			// Create an array object first
			CharStackProber	aStackProbers[] = new CharStackProber[NUM_PROBERS];

			// Then the CharStackProber objects
			for(int i = 0; i < NUM_PROBERS; i++)
				aStackProbers[i] = new CharStackProber();

			System.out.println("main(): CharStackProber threads have been created: " + NUM_PROBERS);

			/*
			 * Twist 'em all
			 */
			ab1.start();
			aStackProbers[0].start();
			rb1.start();
			aStackProbers[1].start();
			ab2.start();
			aStackProbers[2].start();
			rb2.start();

			System.out.println("main(): All the threads are ready.");

			/*
			 * Wait by here for all forked threads to die
			 */
			ab1.join();
			ab2.join();

			rb1.join();
			rb2.join();

			for(int i = 0; i < NUM_PROBERS; i++)
				aStackProbers[i].join();

			// Some final stats after all the child threads terminated...
			System.out.println("System terminates normally.");
			System.out.println("Final value of top = " + soStack.getTop() + ".");
			System.out.println("Final value of stack top = " + soStack.pick() + ".");
			System.out.println("Final value of stack top-1 = " + soStack.getAt(soStack.getTop() - 1) + ".");
			System.out.println("Stack access count = " + soStack.getAccessCounter());

			System.exit(0);
		}
		catch(InterruptedException e)
		{
			System.err.println("Caught InterruptedException (internal error): " + e.getMessage());
			e.printStackTrace(System.err);
		}
		catch(Exception e)
		{
			reportException(e);
		}
		finally
		{
			System.exit(1);
		}
	} // main()


	/**
	 * Inner AcquireBlock thread class.
	 */
	static class AcquireBlock extends BaseThread
	{
		/**
		 * A copy of a block returned by pop().
                 * @see BlocStack#pop()
		 */
		private char cCopy;

		public void run()
		{
			
			System.out.println("AcquireBlock thread [TID=" + this.iTID + "] starts executing.");

			randomYield();

			phase1();
			//Barrier Synchronization
			/*Once done signal all the other processes.*/
			s1.V();//Signal
			yield();

			

			try
			{
                  		//Entering the critical section.
                 		//Lock the semaphore to gurantee atomicity.
                 		mutex.P();

				System.out.println("AcquireBlock thread [TID=" + this.iTID + "] requests Ms block.");

				this.cCopy = soStack.pop();

				System.out.println
				(
					"AcquireBlock thread [TID=" + this.iTID + "] has obtained Ms block " + this.cCopy +
					" from position " + (soStack.getTop() + 1) + "."
				);

				yield();

				System.out.println
				(
					"Acq[TID=" + this.iTID + "]: Current value of top = " +
					soStack.getTop() + "."
				);

				System.out.println
				(
					"Acq[TID=" + this.iTID + "]: Current value of stack top = " +
					soStack.pick() + "."
				);
				
		
				//Critical Section Access is over, release semaphore.
				mutex.V();
	
			}
			catch(Exception e)
			{
				reportException(e);
				System.exit(1);
			}
			//Wait for the other threads to finish before going to Phase II
			s1.P();//Wait
			phase2();
			s1.V();//Signal the other threads to go on...
			randomYield();

			System.out.println("AcquireBlock thread [TID=" + this.iTID + "] terminates.");
			
		}
	} // class AcquireBlock


	/**
	 * Inner class ReleaseBlock.
	 */
	static class ReleaseBlock extends BaseThread
	{
		/**
		 * Block to be returned. Default is 'a' if the stack is empty.
		 */
		private char cBlock = 'a';

		public void run()
		{
			
			System.out.println("ReleaseBlock thread [TID=" + this.iTID + "] starts executing.");

			yield();

			phase1();
			//Barrier Synchronization - signal the other that Phase I is done here.
			s1.V();//Signal
			yield();

			
			try
			{
            			//Entering the CS.
            			//Get Semaphore
            			mutex.P();

				if(soStack.isEmpty() == false)
					this.cBlock = (char)(soStack.pick() + 1);

				yield();

				System.out.println
				(
					"ReleaseBlock thread [TID=" + this.iTID + "] returns Ms block " + this.cBlock +
					" to position " + (soStack.getTop() + 1) + "."
				);

				soStack.push(this.cBlock);

				System.out.println
				(
					"Rel[TID=" + this.iTID + "]: Current value of top = " +
					soStack.getTop() + "."
				);

				System.out.println
				(
					"Rel[TID=" + this.iTID + "]: Current value of stack top = " +
					soStack.pick() + "."
				);
			
				//Critical Section Access is over.
				mutex.V();//Release
			}
			catch(Exception e)
			{
				reportException(e);
				System.exit(1);
			}
			
			yield();
			//Wait for the other threads to finish phase I
			s1.P();//Wait
			phase2();
			s1.V();//Signal the others to go ...
			yield();

			System.out.println("ReleaseBlock thread [TID=" + this.iTID + "] terminates.");
			
		}
	} // class ReleaseBlock


	/**
	 * Inner class CharStackProber to dump stack contents.
	 */
	static class CharStackProber extends BaseThread
	{
		public void run()
		{
			
			phase1();
			//Barrier Synchro - signal the other phase I is done.
			s1.V();//Signal
			yield();

			
			try
			{
				for(int i = 0; i < siThreadSteps; i++)
				{
                		//Entering critical Section.
                		//Get semaphore.
                		mutex.P();
					System.out.print("Stack Prober [TID=" + this.iTID + "]: Stack state: ");

					// [s] - means ordinay slot of a stack
					// (s) - current top of the stack
					for(int s = 0; s < soStack.getSize(); s++)
						System.out.print
						(
							(s == BlockManager.soStack.getTop() ? "(" : "[") +
							BlockManager.soStack.getAt(s) +
							(s == BlockManager.soStack.getTop() ? ")" : "]")
						);

					System.out.println(".");
					
                    		//Critical Section access is over.
                    		//Release Semaphore
                    		mutex.V();
                    
					yield();
				}
			}
			catch(Exception e)
			{
				reportException(e);
				System.exit(1);
			}
			
			yield();
			//Wait for the other processes to finish Phase I
			s1.P();//Wait
			phase2();
			s1.V();//Signal the other to go on ...
			yield();
		
		}
	} // class CharStackProber


	/**
	 * Outputs exception information to STDERR
	 * @param poException Exception object to dump to STDERR
	 */
	private static void reportException(Exception poException)
	{
		System.err.println("Caught exception : " + poException.getClass().getName());
		System.err.println("Message          : " + poException.getMessage());
		System.err.println("Stack Trace      : ");
		poException.printStackTrace(System.err);
	}
} // class BlockManager

// EOF
