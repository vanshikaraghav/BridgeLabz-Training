package online_banking;

class TransactionThread extends Thread {
	 Account account;
	 boolean deposit;
	 double amount;

	 TransactionThread(Account account, boolean deposit, double amount) {
	     this.account = account;
	     this.deposit = deposit;
	     this.amount = amount;
	 }

	 public void run() {
	     try {
	         if (deposit) {
	             account.deposit(amount);
	         } else {
	             account.withdraw(amount);
	         }
	     } catch (Exception e) {
	         System.out.println(e.getMessage());
	     }
	 }
	}