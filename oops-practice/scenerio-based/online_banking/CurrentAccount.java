package online_banking;

class CurrentAccount extends Account {
	CurrentAccount(int accNo, String name, double balance) {
		super(accNo, name, balance);
	}

    double calculateInterest() {
    	return balance * 0.02;	
    }
}