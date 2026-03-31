package scenario_based;
import java.util.*;

class Book {
    String title;
    String author;

    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String toString() {
        return title + " by " + author;
    }
}

class BookShelf {
    private HashMap<String, LinkedList<Book>> catalog = new HashMap<>();

    // Add book
    public void addBook(String genre, Book book) {
        catalog.putIfAbsent(genre, new LinkedList<>());
        catalog.get(genre).add(book);
    }

    // Remove book
    public void removeBook(String genre, String title) {
        if(!catalog.containsKey(genre)) {
        	return;
        }
        LinkedList<Book> books = catalog.get(genre);
        books.removeIf(b -> b.title.equalsIgnoreCase(title));
    }

    // Display catalog
    public void display() {
        for(String genre : catalog.keySet()) {
            System.out.println("Genre: " + genre);
            for(Book b : catalog.get(genre)) {
                System.out.println("  " + b);
            }
        }
    }
}

public class LibraryOrganizeStory {
    public static void main(String[] args) {
        BookShelf shelf = new BookShelf();
        shelf.addBook("Fiction", new Book("2States", "Chetan Bhagat"));
        shelf.addBook("Autobiography", new Book("Wings Of Fire", "A.P.J Abdul Kalam"));
        shelf.addBook("Science", new Book("Brief History of Time", "Stephen Hawking"));
        shelf.display();
        System.out.println("\nAfter borrowing 2States:\n");
        shelf.removeBook("Fiction", "2States");
        shelf.display();
    }
}
