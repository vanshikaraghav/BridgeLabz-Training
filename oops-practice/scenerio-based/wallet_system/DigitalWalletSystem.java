package wallet_system;

public class DigitalWalletSystem {
	public static void main(String[] args) {
        User u1 = new User(1, "Harshita");
        User u2 = new User(2, "Piyush");
        u1.wallet.addMoney(5000);
        TransferService transfer = new WalletTransfer();
        try {
            transfer.transfer(u1, u2, 2000);
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("\nHarshita Transactions:");
        u1.wallet.showTransactions();
        System.out.println("\nPiyush Transactions:");
        u2.wallet.showTransactions();
    }
}
