package wallet_system;

public class Wallet {
	double balance;
    Transaction[] transactions = new Transaction[10];
    int trnCount = 0;

    Wallet() {
        balance = 0;
    }

    void addMoney(double amount) {
        balance += amount;
        transactions[trnCount++] = new Transaction(trnCount, "Credit", amount);
    }

    void withdrawMoney(double amount) throws InsufficientBalanceException {
        if(amount > balance) {
            throw new InsufficientBalanceException("Not enough balance");
        }
        balance -= amount;
        transactions[trnCount++] = new Transaction(trnCount, "Debit", amount);
    }

    void showTransactions() {
        for(int i=0;i<trnCount;i++) {
            transactions[i].display();
        }
    }
}
