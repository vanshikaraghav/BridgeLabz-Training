package class_and_objects;

public class BankAccount {
	
	String accountHolder;
    String accountNumber;
    double balance;

    void deposit(double amount) {
        balance = balance+amount;
        System.out.println("Deposited: "+amount);
    }

    void withdraw(double amount) {
        if(balance>=amount) {
            balance = balance-amount;
            System.out.println("Withdraw amount is : "+amount);
        }else {
            System.out.println("Insufficient balance");
        }
    }

    void displayBalance() {
        System.out.println("Current balance: "+balance);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("                          State of Chennai\n");
        BankAccount account = new BankAccount();
        account.balance = 700.0;
        account.displayBalance();
        account.deposit(200.0);
        account.displayBalance();
        account.withdraw(100.0);
        account.displayBalance();
        account.withdraw(1000.0);
	}

}
