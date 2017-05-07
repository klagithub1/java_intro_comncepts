public class BankTest {

    public static void main (String [] args) {
	    try {
	        BankAccount b = new BankAccount (200);
	        b.deposit (100);
	        BankAccount.transactions_available = false;
	        b.deposit (300);
	        b.withdraw (1000);
	    } 
	    catch (UnavailableTransactionException e) {
	         // wait until it's available or do something appropriate - write to log file
	        System.out.println (e.getMessage ());
	        e.printStackTrace ();
	        System.err.println (e.getMessage ());
	    }
    }
}
