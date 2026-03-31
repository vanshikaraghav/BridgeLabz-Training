package scenario_based;
import java.util.*;

class Item {
    String name;
    double price;
    int stock;

    public Item(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
}

class Customer {
    String customerName;
    List<String> items; 

    public Customer(String customerName, List<String> items) {
        this.customerName = customerName;
        this.items = items;
    }
}

class CheckoutCounter {
    Queue<Customer> customerQueue = new LinkedList<>();
    Map<String, Item> inventory = new HashMap<>();

    public void addItem(Item item) {
        inventory.put(item.name, item);
    }

    public void addCustomer(Customer customer) {
        customerQueue.add(customer);
        System.out.println(customer.customerName + " added to queue");
    }

    public void processCustomer() {
        if(customerQueue.isEmpty()) {
           System.out.println("No customers in queue");
           return;
        }
        Customer customer = customerQueue.poll();
        double totalBill = 0;
        System.out.println("\nBilling for: " + customer.customerName);
        for(String itemName : customer.items) {
           Item item = inventory.get(itemName);
           if(item != null && item.stock > 0) {
              totalBill += item.price;
              item.stock--; 
              System.out.println(itemName + " - " + item.price);
         }else {
             System.out.println(itemName + " - Out of stock");
          }
       }
       System.out.println("Total Bill: " + totalBill);
    }

    public void displayStock() {
        System.out.println("\nCurrent Stock:");
        for(Item item : inventory.values()) {
            System.out.println(item.name + " -> " + item.stock);
        }
    }
}

public class SmartCheckoutSystem {
    public static void main(String[] args) {
        CheckoutCounter counter = new CheckoutCounter();
        counter.addItem(new Item("Milk", 50, 5));
        counter.addItem(new Item("Bread", 40, 3));
        counter.addItem(new Item("Eggs", 10, 10));
        Customer c1 = new Customer("Alice", Arrays.asList("Milk", "Bread"));
        Customer c2 = new Customer("Bob", Arrays.asList("Eggs", "Milk", "Eggs"));
        counter.addCustomer(c1);
        counter.addCustomer(c2);
        counter.processCustomer();
        counter.processCustomer();
        counter.displayStock();
    }
}
