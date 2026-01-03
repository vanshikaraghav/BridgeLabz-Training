package inheritance;

class BankAccount{
	String accountNumber;
	double balance;

	BankAccount(String accountNumber,double balance) {
	     this.accountNumber = accountNumber;
	     this.balance = balance;
	 }

	 void showBasicInfo() {
	     System.out.println("Account Number: " + accountNumber+" | Balance: "+balance);
	 }
}

class SavingsAccount extends BankAccount {
	 double interestRate;

	 SavingsAccount(String accountNumber,double balance,double interestRate) {
	     super(accountNumber,balance);
	     this.interestRate = interestRate;
	 }

	 void displayAccountType() {
	     System.out.println("Account Type: Savings Account");
	     showBasicInfo();
	     System.out.println("Interest Rate: "+interestRate+"%");
	 }
}

class CheckingAccount extends BankAccount {
	 double withdrawalLimit;

	 CheckingAccount(String accountNumber,double balance,double withdrawalLimit) {
	     super(accountNumber,balance);
	     this.withdrawalLimit = withdrawalLimit;
	 }

	 void displayAccountType() {
	     System.out.println("Account Type: Checking Account");
	     showBasicInfo();
	     System.out.println("Withdrawal Limit: "+withdrawalLimit);
	 }
}

class FixedDepositAccount extends BankAccount {
	 int durationInMonths;

	 FixedDepositAccount(String accountNumber,double balance,int durationInMonths) {
	     super(accountNumber,balance);
	     this.durationInMonths = durationInMonths;
	 }

	 void displayAccountType() {
	     System.out.println("Account Type: Fixed Deposit Account");
	     showBasicInfo();
	     System.out.println("Duration: "+durationInMonths+" months");
	 }
}

public class BankAccountSystem {
	public static void main(String[] args) {
		SavingsAccount sa = new SavingsAccount("123456778",15000.0,4.5);
	    CheckingAccount ca = new CheckingAccount("64322454",10000.0,5000.0);
		FixedDepositAccount fd = new FixedDepositAccount("223311009",25000.54,3);
		sa.displayAccountType();
		ca.displayAccountType();
		fd.displayAccountType();
	}
}
