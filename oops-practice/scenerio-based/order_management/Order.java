package order_management;

public class Order {
	int orderId;
	Customer customer;
	Product product;
	String status;
	
	Order(int orderId, Customer customer, Product product, String status){
		this.orderId = orderId;
		this.customer = customer;
		this.product = product;
		this.status = status;
	}
}
