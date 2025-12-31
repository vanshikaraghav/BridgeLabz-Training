package constructors_and_variables;

public class BookSystem {
	
	String title;
    String author;
    double price;

    // Default constructor
    BookSystem() {
        title = "Wings Of Fire";
        author = "A.P.J. Abdul Kalam";
        price = 500.0;
    }

    // Parameterized constructor
    BookSystem(String title, String author,double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    void display() {
        System.out.println("Title: "+title);
        System.out.println("Author: "+author);
        System.out.println("Price: "+price);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BookSystem b1 = new BookSystem();
        BookSystem b2 = new BookSystem("2States", "Chetan Bhagat", 500.0);
        b1.display();
        b2.display();
	}

}
