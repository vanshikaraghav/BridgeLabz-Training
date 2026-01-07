package online_banking;

class SavingsAccount extends Account {
	SavingsAccount(int accNo, String name, double balance) {
		super(accNo, name, balance);
	}

    double calculateInterest() {
    	return balance * 0.04;
    }
}