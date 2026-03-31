package order_management;

public class CashPayment implements Payment{
	public void pay(double amount) throws PaymentFailedException{
		if(amount <=0) {
			throw new PaymentFailedException("Payment Failed!");
		}
		System.out.println("\nPayment of "+amount+" rupees is done by cash.");
	}

}
