package functional_interface;
interface method{
	void pay();
}

class UPI implements method{
	public void pay() {
		System.out.println("Pay by UPI");
	}
}

class credit implements method{
	public void pay() {
		System.out.println("Pay by Credit Card");
	}
}

class wallet implements method{
	public void pay() {
		System.out.println("Pay by Wallet");
	}
}

public class DigitalPaymentInterface {
	public static void main(String[] args) {
		method upi = new UPI();
		method card = new credit();
		method wallet = new wallet();
		
		upi.pay();
		card.pay();
		wallet.pay();
	}
}