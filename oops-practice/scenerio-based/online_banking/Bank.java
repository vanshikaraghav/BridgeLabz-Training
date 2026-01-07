package online_banking;
import java.util.ArrayList;

class Bank {
	ArrayList<Account> accounts = new ArrayList<>();
	
    // CREATE
    void createAccount(Account acc) {
    	accounts.add(acc);
        System.out.println("Account created for " + acc.holderName);
    }

    // READ
    Account findAccount(int accNo) {
    	for(Account a : accounts) {
    		if(a.accountNumber == accNo) {
    			return a;
    		}
    	}
        return null;
    }

    // UPDATE (Transfer)
    void transfer(int fromAcc, int toAcc, double amount)
         throws InsufficientBalanceException {

         Account sender = findAccount(fromAcc);
         Account receiver = findAccount(toAcc);
         if(sender!=null && receiver!=null) {
        	 synchronized (this) {
             sender.withdraw(amount);
             receiver.deposit(amount);
             sender.transactions.add("Transferred " + amount + " to " + toAcc);
             receiver.transactions.add("Received " + amount + " from " + fromAcc);
         }
     }
 }
}