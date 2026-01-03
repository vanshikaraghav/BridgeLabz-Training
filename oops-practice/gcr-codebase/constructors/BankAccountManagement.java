package constructors_and_variables;

class BankAccount {
    public int accountNumber;
    protected String accountHolder;
    private double balance;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double amount) {
        this.balance = amount;
    }
}

class SavingsAccount extends BankAccount {
    void displayDetails() {
        System.out.println("Account Number: "+accountNumber+" | Account Holder: "+accountHolder+" | Balance: "+getBalance());
    }
}

public class BankAccountManagement {
	public static void main(String[] args) {
		SavingsAccount account = new SavingsAccount();
        account.accountNumber = 11223344;
        account.accountHolder = "Aman";
        account.setBalance(20000);
        account.displayDetails();
        account.setBalance(12000);
        System.out.println("Updated Balance: " + account.getBalance());
	}

}
