package this_static_final_instance;

class BankAccount {
	
	static String bankName = "State Bank of India";
    static int totalAccounts = 0;
    final int accountNumber;
    String accountHolderName;
    double balance;

    BankAccount(int accountNumber,String accountHolderName,double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        totalAccounts++;
    }

    static void getTotalAccounts() {
        System.out.println("Total Accounts: "+totalAccounts+"\n");
    }

    void displayAccountDetails(Object obj) {
        if(obj instanceof BankAccount) {
            System.out.println("Bank Name: "+bankName);
            System.out.println("Account Number: "+accountNumber);
            System.out.println("Account Holder Name: "+accountHolderName);
            System.out.println("Balance: "+balance+"\n");
        }
    }
}

public class BankAccountSystem {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount(110011,"Aman",5000.0);
        BankAccount account2 = new BankAccount(110012,"Rahul",8000.0);
        BankAccount.getTotalAccounts();
        account1.displayAccountDetails(account1);
        account2.displayAccountDetails(account2);
    }
}