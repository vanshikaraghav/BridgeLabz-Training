package order_management;

public interface Payment {
	
	void pay(double amount) throws PaymentFailedException;
}
