package this_static_final_instance;

class Book {
	
    static String libraryName = "Egmore Library";
    final String isbn;
    String title;
    String author;

    Book(String title, String author,String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    static void displayLibraryName() {
        System.out.println("Library Name: " + libraryName);
    }

    void displayBookDetails(Object obj) {
        if(obj instanceof Book) {
            System.out.println("Title: "+title+" | Author: "+author+" | ISBN: "+isbn);
        }
    }
}

public class LibraryManagementSystem {
	public static void main(String[] args) {
        Book book = new Book("Effective Java", "Joshua Bloch", "978-0134685991");
        Book.displayLibraryName();
        book.displayBookDetails(book);
    }
}
