package encapsulation_and_abstraction;

interface Loanable {
    void applyForLoan(double amount);
    double calculateLoanEligibility();
}

abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;

    BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public String getAccountNumber() { 
    	return accountNumber;
    }
    
    public String getHolderName() { 
    	return holderName;
    }
    
    public double getBalance() { 
    	return balance;
    }
    
    protected void setBalance(double balance) { 
    	this.balance = balance;
    }

    void deposit(double amount) {
        if(amount>0) {
            balance += amount;
            System.out.println(amount+" deposited successfully");
        }
    }

    void withdraw(double amount) {
        if(amount<=balance) {
            balance -= amount;
            System.out.println(amount + " withdrawn successfully");
        }else {
            System.out.println("Insufficient balance!");
        }
    }

    public abstract double calculateInterest();

    void displayAccount() {
        System.out.println("Account Number: " + accountNumber+" | Holder Name: "+holderName+" | Balance: "+balance);
    }
}

class SavingsAccount extends BankAccount implements Loanable {
    private double interestRate;

    SavingsAccount(String accountNumber, String holderName, double balance, double interestRate) {
        super(accountNumber, holderName, balance);
        this.interestRate = interestRate;
    }

    public double calculateInterest() {
        return getBalance() * interestRate / 100;
    }

    public void applyForLoan(double amount) {
        System.out.println("Savings account loan request submitted for " + amount);
    }

    public double calculateLoanEligibility() {
        return getBalance() * 0.5;
    }
}

class CurrentAccount extends BankAccount implements Loanable {
    private double interestRate;

    CurrentAccount(String accountNumber, String holderName, double balance, double interestRate) {
        super(accountNumber, holderName, balance);
        this.interestRate = interestRate;
    }

    public double calculateInterest() {
        return getBalance() * interestRate / 100;
    }

    public void applyForLoan(double amount) {
        System.out.println("Current account loan request submitted for " + amount);
    }

    public double calculateLoanEligibility() {
        return getBalance() * 0.3;
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        BankAccount account1 = new SavingsAccount("SA123", "Aman", 50000, 4.0);
        BankAccount account2 = new CurrentAccount("CA456", "Vanshika", 100000, 2.5);
        BankAccount[] accounts = {account1, account2};
        for(BankAccount acc : accounts) {
            System.out.println("===============");
            acc.displayAccount();
            double interest = acc.calculateInterest();
            System.out.println("Interest: " + interest);
            if(acc instanceof Loanable) {
                Loanable loan = (Loanable) acc;
                loan.applyForLoan(20000);
                System.out.println("Loan Eligibility: " + loan.calculateLoanEligibility());
            }
            System.out.println("===============\n");
        }
    }
}
