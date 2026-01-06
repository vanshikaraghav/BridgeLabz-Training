package scenario_based;

class BankAccount {
    int accountNumber;
    double balance;
    
    BankAccount(int accountNumber,double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: "+amount);
    }

    void withdraw(double amount) {
        if(amount<=balance) {
            balance -= amount;
            System.out.println("Withdrawn: "+amount);
        }else {
            System.out.println("Insufficient balance");
        }
    }

    void checkBalance() {
        System.out.println("Current Balance: "+balance);
    }
}

public class BankAccountManager {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(101,500);
        account.checkBalance();
        account.deposit(200);
        account.withdraw(100);
        account.withdraw(700);
        account.checkBalance();
    }
}

