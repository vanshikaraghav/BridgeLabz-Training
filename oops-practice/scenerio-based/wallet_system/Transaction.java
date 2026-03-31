package wallet_system;

public class Transaction {
	int trnId;
    String type;
    double amount;

    Transaction(int txnId, String type, double amount) {
        this.trnId = txnId;
        this.type = type;
        this.amount = amount;
    }

    void display() {
        System.out.println(trnId + " | " + type + " | " + amount);
    }
}
