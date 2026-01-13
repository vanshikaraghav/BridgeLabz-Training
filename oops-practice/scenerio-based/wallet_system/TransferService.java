package wallet_system;

public interface TransferService {
	void transfer(User from, User to, double amount) throws InsufficientBalanceException;
}
