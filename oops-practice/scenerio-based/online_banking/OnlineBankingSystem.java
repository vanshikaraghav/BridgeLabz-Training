package online_banking;

public class OnlineBankingSystem {
	 public static void main(String[] args) {
	     Bank bank = new Bank();
	     Account account1 = new SavingsAccount(101, "Harshita", 5000);
	     Account account2 = new CurrentAccount(102, "Amit", 3000);
	     bank.createAccount(account1);
	     bank.createAccount(account2);
	     Thread t1 = new TransactionThread(account1, true, 2000);
	     Thread t2 = new TransactionThread(account1, false, 1000);
	     t1.start();
	     t2.start();
	     try {
	         t1.join();
	         t2.join();
	     } catch (InterruptedException e) {}
	     try {
	         bank.transfer(101, 102, 1500);
	     } catch (InsufficientBalanceException e) {
	         System.out.println(e.getMessage());
	     }
	     System.out.println("\nAccount Details\n");
	     System.out.println("Savings Account Interest: " + account1.calculateInterest());
	     account1.showBalance();
	     account1.showTransactions();
	     System.out.println("\nCurrent Account Interest: " + account2.calculateInterest());
	     account2.showBalance();
	     account2.showTransactions();
	 }
	}