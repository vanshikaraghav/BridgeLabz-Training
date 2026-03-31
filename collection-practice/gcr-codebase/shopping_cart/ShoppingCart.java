package shopping_cart;
import java.util.*;

public class ShoppingCart {
    private HashMap<String, Double> priceMap = new HashMap<>();
    private LinkedHashMap<String, Double> cart = new LinkedHashMap<>();

    public void addProduct(String product, double price) {
        priceMap.put(product, price);
        cart.put(product, price);
    }

    public void displayCart() {
        System.out.println("\nCart Items (Insertion Order):");
        for(Map.Entry<String, Double> entry : cart.entrySet()) {
            System.out.println(entry.getKey() + " -> ₹" + entry.getValue());
        }
    }

    public void displaySortedByPrice() {
        System.out.println("\nCart Items (Sorted by Price):");
        TreeMap<Double, String> sortedMap = new TreeMap<>();
        for(Map.Entry<String, Double> entry : cart.entrySet()) {
            sortedMap.put(entry.getValue(), entry.getKey());
        }
        for(Map.Entry<Double, String> entry : sortedMap.entrySet()) {
            System.out.println(entry.getValue() + " -> ₹" + entry.getKey());
        }
    }

    public void calculateTotal() {
        double total = 0;
        for(double price : cart.values()) {
            total += price;
        }
        System.out.println("\nTotal Amount: ₹" + total);
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct("Laptop", 55000);
        cart.addProduct("Headphones", 2000);
        cart.addProduct("Mouse", 500);
        cart.addProduct("Keyboard", 1500);
        cart.displayCart();
        cart.displaySortedByPrice();
        cart.calculateTotal();
    }
}
