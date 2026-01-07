package online_banking;

class InsufficientBalanceException extends Exception {
	InsufficientBalanceException(String msg) {
     super(msg);
	}
}