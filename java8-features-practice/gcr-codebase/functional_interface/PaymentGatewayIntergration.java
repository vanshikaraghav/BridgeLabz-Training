package functional_interface;
interface PaymentProcessor {

	void processPayment(double amount);
	default void refund(double amount) {
		System.out.println("Refund of ₹" + amount + " processed using standard flow");
	}
}

class PaytmProcessor implements PaymentProcessor {

	public void processPayment(double amount) {
		System.out.println("Paytm payment of ₹" + amount + " successful");
	}
}

class RazorpayProcessor implements PaymentProcessor {

	public void processPayment(double amount) {
		System.out.println("Razorpay payment of ₹" + amount + " successful");
	}

	public void refund(double amount) {
		System.out.println("Razorpay refund of ₹" + amount + " processed instantly");
	}
}

public class PaymentGatewayIntergration {

	public static void main(String[] args) {

		PaymentProcessor paytm = new PaytmProcessor();
		PaymentProcessor razorpay = new RazorpayProcessor();

		paytm.processPayment(5000);
		paytm.refund(1000);

		razorpay.processPayment(8000);
		razorpay.refund(2000);
	}
}