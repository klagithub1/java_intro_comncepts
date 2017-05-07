/**
 * Class Monitor
 * To synchronize dining philosophers.
 *
 * @author Serguei A. Mokhov, mokhov@cs.concordia.ca
 * @updated KLAJDI KARANXHA 6173780, k_karanx@encs.concordia.ca
 */
public class Monitor
{
	/*
	 * ------------
	 * Data members
	 * ------------
	 */
	
	/**
	 * This array of states determine the state of the fork that is close to a Philosopher.
	 * State of a fork is either FREE or TAKEN.
	 * */
	 int[] fork;
	
	/**
	 * Defines the states of the philosophers which can be either
	 * Eating, Hungry, Thinking, or Talking(Task 3)
	 * */
	 int[] state;

	/**
	 * Constructor
	 */
	public Monitor(int piNumberOfPhilosophers)
	{
		//Number of forks is the same as the number of philosophers.
		//Number of states is also the same as the number of philosophers
		this.state = new int[piNumberOfPhilosophers];
		this.fork = new int[piNumberOfPhilosophers];
		//initiate all forks to AVAILABLE and all philosophers are THINKING.
		for(int i =0; i < piNumberOfPhilosophers; i++)
		{
			fork[i] = forkState.FREE;
			state[i] = philosopherState.THINKING;
		}
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
	public void pickUp(final int piTID)
	{
		state[piTID] = philosopherState.HUNGRY;
		System.out.println("Philosopher "+piTID+" is HUNGRY.");
		if((piTID%2)==0)
		{
			acquireFork(piTID);
			acquireFork(((piTID+(fork.length-1))%fork.length));
			state[piTID] = philosopherState.EATING;
			
		}
		else
		{
			acquireFork(((piTID+(fork.length-1))%fork.length));
			acquireFork(piTID);
			state[piTID] = philosopherState.EATING;
		}
		
//		if(piTID == 0)
//		{
//			if(acquireFork(((piTID+(fork.length-1))%fork.length))
//					&& acquireFork(piTID))
//			{
//				state[piTID] = philosopherState.EATING;
//				notifyAll();
//				
//			}
//			else
//			{
//				try {
//					wait();
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		}
//		else
//		{
//			if(acquireFork(piTID)
//					&& acquireFork(((piTID+(fork.length-1))%fork.length)))
//			{
//				state[piTID] = philosopherState.EATING;
//				notifyAll();
//				
//			}
//			else
//			{
//				try {
//					wait();
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		}
//		
//		
		
		
//                test(piTID);
//                if(state[piTID] != philosopherState.EATING)
//                {
//                    try {
//                    	System.out.println("Philosopher "+piTID+" couldn't pick up and is going to wait.");
//                     wait();
//                     } catch (InterruptedException ex)
//                     {
//                       System.out.println(ex.getMessage());
//                     }
//                }
	}

	/**
	 * When a given philosopher's done eating, they put the chopstiks/forks down
	 * and let others know they are available.
	 */
	public void putDown(final int piTID)
	{
		
		state[piTID] = philosopherState.THINKING;
		System.out.println("Philosopher "+piTID+" finished eating and now is THINKING");
		if((piTID%2) == 0)
		{
			releaseFork(piTID);
			releaseFork(((piTID+(fork.length-1))%fork.length));
		}
		else
		{
			releaseFork(((piTID+(fork.length-1))%fork.length));
			releaseFork(piTID);
		}
		
		
//		if(piTID == 0)
//		{
//			releaseFork(((piTID+(fork.length-1))%fork.length));
//			releaseFork(piTID);
//		}
//		else
//		{
//			releaseFork(piTID);
//			releaseFork(((piTID+(fork.length-1))%fork.length));
//		}
//		
//                test((piTID+(state.length-1))%state.length);
//                test((piTID+1)%state.length);
        
		
		
	}

	/**
	 * Only one philosopher at a time is allowed to philosophy
	 * (while she is not eating).
	 */
	public synchronized void requestTalk()
	{
		// ...
	}

	/**
	 * When one philosopher is done talking stuff, others
	 * can feel free to start talking.
	 */
	public synchronized void endTalk()
	{
		// ...
	}
	
	
	/**
	 * Test the status of the neighbours before 
	 * picking up and putting down the forks.
	 */
	public synchronized void test(int i)
	{
		if((state[(i+(state.length-1))%state.length] != philosopherState.EATING)
				&&(state[i] == philosopherState.HUNGRY)
				&&(state[(i+1)%state.length] != philosopherState.EATING))
		{
			state[i] = philosopherState.EATING;
			System.out.println("Philosopher "+i+" is eating.");
			notifyAll();
			
		}
		
		
	}
	
	/**
	 * Checks if a fork can be taken or not.
	 * @param i
	 * @return boolean variable.
	 */
	public synchronized void acquireFork(int i)
	{
		if(fork[i] == forkState.TAKEN)
		{
			try {
				System.out.println("Philosopher "+i+" couldn't pick up the forks!!");
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else
		{
			fork[i] = forkState.TAKEN;
			notifyAll();
		}
		
			
	}
	
	/**
	 * Check if you can release the forks. 
	 * THe thread releases the resource in the order they were picked up.
	 */
	public synchronized void releaseFork(int i)
	{
		fork[i] = forkState.FREE;
		
	}
	
}// EOF
