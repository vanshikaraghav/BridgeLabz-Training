package inheritance;

class Order{
	String orderId;
	 String orderDate;

	 Order(String orderId, String orderDate) {
	     this.orderId = orderId;
	     this.orderDate = orderDate;
	 }
	 
	 void getOrderStatus() {
		 System.out.println("OrderId: "+orderId+" | Order Date: "+orderDate);
		 System.out.println("Status: Order Placed Successfully");
	 }
}

class ShippedOrder extends Order {
	 String trackingNumber;

	 ShippedOrder(String orderId,String orderDate,String trackingNumber) {
	     super(orderId,orderDate);
	     this.trackingNumber = trackingNumber;
	 }

	 void getOrderStatus() {
	     super.getOrderStatus();
	     System.out.println("tracking number is: "+trackingNumber);
	 }
}

class DeliveredOrder extends ShippedOrder {
	 String deliveryDate;

	 public DeliveredOrder(String orderId,String orderDate,String trackingNumber,String deliveryDate) {
	     super(orderId,orderDate,trackingNumber);
	     this.deliveryDate = deliveryDate;
	 }

	 public void getOrderStatus() {
	     super.getOrderStatus();
	     System.out.println("Delivery Date: "+deliveryDate);
	 }
}

public class OnlineRetailOrder {
	public static void main(String[] args) {
		DeliveredOrder order = new DeliveredOrder("123","2025-12-01","TRK456789","2025-12-05");
	     order.getOrderStatus();
	}

}
