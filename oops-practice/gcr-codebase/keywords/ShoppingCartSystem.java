package this_static_final_instance;

class Product{
	static double discount = 10.0;
    final String productID;
    String productName;
    double price;
    int quantity;
    
    Product(String productID,String productName,double price,int quantity){
    	this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }
    
    static void updateDiscount(double newDiscount) {
        discount = newDiscount;
    }

    void displayProduct(Object obj) {
        if(obj instanceof Product) {
            double discountedPrice = price-(price*discount/100);
            System.out.println("Product ID: "+productID);
            System.out.println("Product Name: "+productName);
            System.out.println("Price: $"+price);
            System.out.println("Quantity: "+quantity);
            System.out.println("Discount: "+discount+"%");
            System.out.println("Price after Discount: $"+discountedPrice);
            System.out.println();
        }
    }
}

public class ShoppingCartSystem {
	public static void main(String[] args) {
        Product p1 = new Product("P001","Laptop",1200.0, 5);
        Product p2 = new Product("P002","Smartphone",800.0,10);
        p1.displayProduct(p1);
        p2.displayProduct(p2);
    }
}
