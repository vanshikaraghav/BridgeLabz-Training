package constructors_and_variables;

public class Book1 {
	
	String title;
    String author;
    double price;
    boolean availability;
    
    Book1(String title,String author,double price,boolean availability){
    	this.title = title;
    	this.author = author;
    	this.price = price;
    	this.availability = true;
    }
    
    void borrowBook() {
    	if(availability) {
    		availability = false;
    		System.out.println(title+" is borrowed.");
    	}else {
    		System.out.println(title+" is not available");
    	}
    }
    
    void display() {
        System.out.println("Title: "+title+" | Author: "+author+" | Price: "+price+" | Availability: "+availability);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Book1 b1 = new Book1("2States","Chetan Bhagat",500.0,false);
		b1.display();
		b1.borrowBook();
	}

}
