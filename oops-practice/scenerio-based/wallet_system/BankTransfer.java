package wallet_system;

public class BankTransfer implements TransferService {
	
    public void transfer(User from, User to, double amount) throws InsufficientBalanceException {
        from.wallet.withdrawMoney(amount);
        System.out.println("Bank Transfer Initiated to " + to.name);
    }
}
