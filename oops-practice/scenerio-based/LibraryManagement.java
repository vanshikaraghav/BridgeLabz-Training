package scenario_based;
import java.util.ArrayList;
import java.util.List;

class BookNotAvailableException extends Exception {
    BookNotAvailableException(String msg) {
        super(msg);
    }
}

class Book {
    String title;
    String author;
    boolean isAvailable;

    Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }
}

public class LibraryManagement {
    static List<Book> books = new ArrayList<>();

    public static void displayBooks() {
        for(Book b : books) {
            System.out.println(b.title + " | " + b.author +" | " + (b.isAvailable ? "Available" : "Checked Out"));
        }
    }

    public static void searchByTitle(String keyword) {
        System.out.println("Search Results:");
        for(Book b : books) {
            if(b.title.toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(b.title + " by " + b.author);
            }
        }
    }

    static void checkoutBook(String title) throws BookNotAvailableException {
        for(Book b : books) {
            if(b.title.equalsIgnoreCase(title)) {
                if(!b.isAvailable) {
                    throw new BookNotAvailableException("Book is already checked out");
                }
                b.isAvailable = false;
                System.out.println("Book checked out successfully");
                return;
            }
        }
        System.out.println("Book not found");
    }

    public static void main(String[] args) {
        Book[] bookArray = {
                new Book("Java Basics", "James"),
                new Book("2States", "Chetan Bhagat"),
                new Book("Wings Of Fire", "A.P.J. Abdul Kalam")};
        for(Book b : bookArray) {
            books.add(b);
        }
        displayBooks();
        searchByTitle("java");
        try{
            checkoutBook("Java Basics");
            checkoutBook("Java Basics");
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        displayBooks();
    }
}
