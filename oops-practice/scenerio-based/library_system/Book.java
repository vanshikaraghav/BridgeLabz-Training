package library_system;

public class Book {
	int bookId;
    String title;
    boolean isAvailable = true;

    Book(int bookId, String title) {
        this.bookId = bookId;
        this.title = title;
    }
}
