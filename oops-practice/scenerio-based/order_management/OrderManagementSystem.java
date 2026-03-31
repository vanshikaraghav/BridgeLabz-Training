package order_management;

public class OrderManagementSystem {
	public static void main(String[] args) {
		
		OrderService service = new OrderService();
        service.addProduct(new Product(1, "Laptop", 60000));
        service.addProduct(new Product(2, "Mobile", 25000));
        service.addProduct(new Product(3, "EarBuds", 3000));
        Customer c1 = new Customer(101, "Harshita");
        service.displayProducts();
        Payment card = new CardPayment();
        Payment upi = new UpiPayment();
        service.placeOrder(1, c1, 1, card);
        service.placeOrder(2, c1, 3, upi);
        service.cancelOrder(2);
        service.showOrders();
    }
}
