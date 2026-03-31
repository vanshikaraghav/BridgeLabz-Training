package order_management;

public class UpiPayment implements Payment{
	public void pay(double amount) throws PaymentFailedException{
		if(amount <=0) {
			throw new PaymentFailedException("Payment Failed!");
		}
		System.out.println("Payment of "+amount+" rupees is done by UPI.");
	}
}
