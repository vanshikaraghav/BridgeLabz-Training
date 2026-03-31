package lambda_expressions;
import java.util.*;
import java.util.List;

class Product{
	String name;
	double price;
	double rating;
	double discount;
	Product(String name,double price, double rating, double discount){
		this.name=name;
		this.price=price;
		this.rating=rating;
		this.discount=discount;
		}
	public String toString() {
		return name + " | Price: " + price +
	               " | Rating: " + rating +
	               " | Discount: " + discount;
	}
}

public class product_sorting {
     public static void main(String [] args) {
    	 List<Product> products=new ArrayList<>();
    	 products.add(new Product("Phone", 50000, 4.5,10));
    	 products.add(new Product("Laptop", 60000,5,8));
    	 products.add(new Product("Headphones", 5000,4.8,10));
    	 
    	 products.sort((p1,p2)->Double.compare(p1.price, p2.price));
    	 System.out.println("Sorted By Price");
    	 products.forEach(System.out::println);
    	 
    	 products.sort((p1,p2)->Double.compare(p1.rating,p2.rating));
    	 System.out.println("Sorted by rating");
    	 products.forEach(System.out::println);
    	 
    	 products.sort((p1,p2)->Double.compare(p1.discount,p2.discount));
    	 System.out.println("Sorted by discount");
    	 products.forEach(System.out::println);
     }
}
