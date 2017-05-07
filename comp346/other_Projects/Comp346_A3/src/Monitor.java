/**
 * Class Monitor
 * To synchronize dining philosophers.
 *
 * @author Serguei A. Mokhov, mokhov@cs.concordia.ca
 */
public class Monitor
{
	/*
	 * ------------
	 * Data members
	 * ------------
	 */
	private boolean[] chopsticks;
	private boolean talk;

	/**
	 * Constructor
	 */
	public Monitor(int piNumberOfPhilosophers)
	{
		// Set appropriate number of chopsticks based on the # of philosophers
		this.chopsticks = new boolean[piNumberOfPhilosophers];
	}

	/*
	 * -------------------------------
	 * User-defined monitor procedures
	 * -------------------------------
	 */

	/**
	 * Grants request (returns) to eat when both chopsticks/forks are available.
	 * Else forces the philosopher to wait()
	 */
	public synchronized void pickUp(final int piTID)
	{
		// Check if both chopsticks are available.
		while (	this.chopsticks[piTID - 1] ||
				this.chopsticks[piTID % this.chopsticks.length])
		{
			// At least one chopstick is not available, force the philosopher to wait.
			try
			{
				this.wait();
			}
			catch(InterruptedException e)
			{
				System.err.println("Monitor.pickUp():");
				DiningPhilosophers.reportException(e);
				System.exit(1);
			}
		}
		
		// Make the philosopher pick up both chopsticks.
		this.chopsticks[piTID - 1] = true;
		this.chopsticks[piTID % this.chopsticks.length] = true;
	}

	/**
	 * When a given philosopher's done eating, they put the chopstiks/forks down
	 * and let others know they are available.
	 */
	public synchronized void putDown(final int piTID)
	{
		// Make the philosopher put down both chopsticks.
		this.chopsticks[piTID - 1] = false;
		this.chopsticks[piTID % this.chopsticks.length] = false;
		
		// Notify the other philosophers that there are chopsticks available.
		this.notifyAll();
	}

	/**
	 * Only one philopher at a time is allowed to philosophy
	 * (while he is not eating).
	 */
	public synchronized void requestTalk()
	{
		// Check if another philosopher is currently talking.
		while (this.talk)
		{
			// Force the philosopher to wait for its turn to talk.
			try
			{
				this.wait();
			}
			catch(InterruptedException e)
			{
				System.err.println("Monitor.requestTalk():");
				DiningPhilosophers.reportException(e);
				System.exit(1);
			}
		}
		this.talk = true;
	}

	/**
	 * When one philosopher is done talking stuff, others
	 * can feel free to start talking.
	 */
	public synchronized void endTalk()
	{
		this.talk = false;
		
		// Notify the other philosophers that they can start talking if they want to.
		this.notifyAll();
	}
}

// EOF
