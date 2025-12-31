package class_and_objects;

public class CartItem {
	
	String itemName;
    double price;
    int quantity;

    void addItem(int quantity1) {
        quantity = quantity+quantity1;
        System.out.println("Added "+quantity1+" of "+itemName+" to the cart.");
    }

    void removeItem(int quantity1) {
        quantity = quantity-quantity1;
        if(quantity<0) {
            quantity = 0;
        }
        System.out.println("Removed "+quantity1+" of "+itemName+" from the cart.");
    }

    void displayTotalCost() {
        double totalCost = price*quantity;
        System.out.println("Total cost: $"+totalCost);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CartItem cart = new CartItem();
        cart.itemName = "Laptop";
        cart.price = 999.99;
        cart.quantity = 1;
        System.out.println("Item: "+cart.itemName+", Price: $"+cart.price+", Quantity: "+cart.quantity);
        cart.addItem(2);
        cart.removeItem(1);
        cart.displayTotalCost();
	}

}
