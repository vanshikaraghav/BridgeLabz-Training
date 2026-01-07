package online_banking;

interface BankService {
	void deposit(double amount);
    void withdraw(double amount) throws InsufficientBalanceException;
    void showBalance();
}