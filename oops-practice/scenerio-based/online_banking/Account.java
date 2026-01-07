package online_banking;
import java.util.ArrayList;

abstract class Account implements BankService {
	int accountNumber;
    String holderName;
    double balance;
    ArrayList<String> transactions = new ArrayList<>();
    
    Account(int accountNumber, String holderName, double balance) {
     this.accountNumber = accountNumber;
     this.holderName = holderName;
     this.balance = balance;
    }

    abstract double calculateInterest();

     // synchronized for multithreading 
     public synchronized void deposit(double amount) {
    	 balance += amount;
         transactions.add("Deposited: " + amount);
     }

     public synchronized void withdraw(double amount) throws InsufficientBalanceException {
    	 if(amount>balance) {
         throw new InsufficientBalanceException("Insufficient Balance!");
     }
     balance -= amount;
     transactions.add("Withdrawn: " + amount);
     }

     public void showBalance() {
    	 System.out.println("Balance: " + balance);
     }

     void showTransactions() {
    	 System.out.println("Transaction History:");
         for (String t : transactions) {
        	 System.out.println(t);
         }
     }
}