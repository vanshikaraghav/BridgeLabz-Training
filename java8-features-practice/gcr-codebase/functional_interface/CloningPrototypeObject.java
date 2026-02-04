package functional_interface;
class Product implements Cloneable {

    int productId;
    String productName;

    Product(int productId, String productName) {
        this.productId = productId;
        this.productName = productName;
    }
 
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();  
    }

    public String toString() {
        return "Product [id: " + productId + ", name: " + productName + "]";
    }
}

public class CloningPrototypeObject {

    public static void main(String[] args) {

        try {
            Product original = new Product(101, "Insurance Policy");
            Product copy = (Product) original.clone();

            System.out.println("Original Object: " + original);
            System.out.println("Cloned Object: " + copy);

        } catch (CloneNotSupportedException e) {
            System.out.println("Cloning not supported");
        }
    }
}