package encapsulation_and_abstraction;

interface Reservable {
    void reserveItem(String borrowerName);
    boolean checkAvailability();
}

abstract class LibraryItem {
    private String itemId;
    private String title;
    private String author;

    LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    public String getItemId() { 
    	return itemId;
    }
    
    public String getTitle() { 
    	return title;
    }
    
    public String getAuthor() { 
    	return author;
    }

    public abstract int getLoanDuration();

    void getItemDetails() {
        System.out.println("Item ID: " + itemId+" | Title: "+title+" | Author: "+author);
    }
}

class Book extends LibraryItem implements Reservable {
    private boolean available = true;
    private String borrower;

    public Book(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    public int getLoanDuration() {
        return 14;
    }

    public void reserveItem(String borrowerName) {
        if(available) {
            borrower = borrowerName;
            available = false;
            System.out.println("Book reserved by: " + borrowerName);
        }else {
            System.out.println("Book is already reserved.");
        }
    }

    public boolean checkAvailability() {
        return available;
    }
}

class Magazine extends LibraryItem implements Reservable {
    private boolean available = true;
    private String borrower;

    public Magazine(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    public int getLoanDuration() {
        return 7;
    }

    public void reserveItem(String borrowerName) {
        if(available) {
            borrower = borrowerName;
            available = false;
            System.out.println("Magazine reserved by: " + borrowerName);
        }else {
            System.out.println("Magazine is already reserved.");
        }
    }

    public boolean checkAvailability() {
        return available;
    }
}

class DVD extends LibraryItem implements Reservable {
    private boolean available = true;
    private String borrower;

    public DVD(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    public int getLoanDuration() {
        return 3;
    }

    public void reserveItem(String borrowerName) {
        if(available) {
            borrower = borrowerName;
            available = false;
            System.out.println("DVD reserved by: " + borrowerName);
        }else {
            System.out.println("DVD is already reserved.");
        }
    }

    public boolean checkAvailability() {
        return available;
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        LibraryItem item1 = new Book("B101", "Java Basics", "James Gosling");
        LibraryItem item2 = new Magazine("M202", "2States", "Chetan Bhagat");
        LibraryItem item3 = new DVD("D303", "Wings Of Fire", "A.P.J. Abdul Kalam");
        LibraryItem[] items = {item1, item2, item3};
        for(LibraryItem item : items) {
            System.out.println("===============");
            item.getItemDetails();
            System.out.println("Loan Duration: " + item.getLoanDuration() + " days");
            if(item instanceof Reservable) {
                Reservable r = (Reservable) item;
                System.out.println("Available: " + r.checkAvailability());
                r.reserveItem("John Doe");
                System.out.println("Available After Reservation: " + r.checkAvailability());
            }
            System.out.println("===============\n");
        }
    }
}
