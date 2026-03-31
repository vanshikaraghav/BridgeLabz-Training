package order_management;
import java.util.*;

public class OrderService {
	
	ArrayList<Product> products = new ArrayList<>();
    ArrayList<Order> orders = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public void displayProducts() {
        System.out.println("Available Products:");
        for(Product p : products) {
            System.out.println(p.productId + " | " + p.name + " | " + p.price);
        }
    }

    public void placeOrder(int orderId, Customer customer, int productId, Payment payment) {
        for(Product p : products) {
            if(p.productId == productId) {
                try {
                    payment.pay(p.price);
                    Order order = new Order(orderId, customer, p, null);
                    orders.add(order);
                    System.out.println("Order placed successfully\n");
                    return;
                }catch(PaymentFailedException e) {
                    System.out.println(e.getMessage());
                    return;
                }
            }
        }
        System.out.println("Product not found");
    }

    public void cancelOrder(int orderId) {
        for(Order o : orders) {
            if(o.orderId == orderId) {
                o.status = "CANCELLED";
                System.out.println("Order cancelled");
                return;
            }
        }
        System.out.println("Order not found");
    }

    public void showOrders() {
        System.out.println("\nOrder History:");
        for(Order o : orders) {
            System.out.println(
                "Order ID: " + o.orderId +
                " | Customer: " + o.customer.name +
                " | Product: " + o.product.name +
                " | Status: " + o.status);
        }
    }
}
