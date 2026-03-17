package m1_questions;

import java.util.*;

abstract class Product {
    String name;
    double price;
    int quantity;

    Product(String n, double p, int q){
        name = n;
        price = p;
        quantity = q;
    }

    abstract void display();

    double getValue(){
        return price * quantity;
    }
}

// Electronics
class Electronics extends Product {
    int warranty;

    Electronics(String n, double p, int q, int w){
        super(n,p,q);
        warranty = w;
    }

    void display(){
        System.out.println(name + " - Price: " + price +
                ", Quantity: " + quantity +
                ", Warranty: " + warranty + " months");
    }
}

// Clothing
class Clothing extends Product {
    String size;

    Clothing(String n, double p, int q, String s){
        super(n,p,q);
        size = s;
    }

    void display(){
        System.out.println(name + " - Price: " + price +
                ", Quantity: " + quantity +
                ", Size: " + size);
    }
}

public class store_inventory_system {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        List<Product> list = new ArrayList<>();

        for(int i=0;i<n;i++){

            String line = sc.nextLine().trim();
            if(line.isEmpty()){ i--; continue; } // skip blank lines

            String[] p = line.split(",\\s*");

            if(p[0].equals("Electronics")){
                list.add(new Electronics(
                        p[1],
                        Double.parseDouble(p[2]),
                        Integer.parseInt(p[3]),
                        Integer.parseInt(p[4])
                ));
                System.out.println("Product added to inventory: " + p[1]);
            }
            else if(p[0].equals("Clothing")){
                list.add(new Clothing(
                        p[1],
                        Double.parseDouble(p[2]),
                        Integer.parseInt(p[3]),
                        p[4]
                ));
                System.out.println("Product added to inventory: " + p[1]);
            }
        }

        // Display Inventory
        System.out.println("Inventory:");
        double total = 0;

        for(Product p : list){
            p.display();
            total += p.getValue();
        }

        // Total value
        System.out.printf("Total value of the inventory: %.2f\n", total);
    }
}
