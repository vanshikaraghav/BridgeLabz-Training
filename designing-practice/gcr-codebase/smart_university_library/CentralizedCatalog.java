package smart_university_library;
import java.util.*;

interface Observer {
    void update(String message);
}

public class CentralizedCatalog {

	private static volatile CentralizedCatalog instance; 
	private List<Book> books = new ArrayList<>();
	private List<Observer> observer = new ArrayList<>();

	private CentralizedCatalog () {}

	public static CentralizedCatalog getInstance() {
		if(instance == null) {
			synchronized(CentralizedCatalog.class) { 
				if(instance == null) {
					instance = new CentralizedCatalog();
				}
			}
		}
			return instance;
	}
	
	public void addBook(Book book) {
		books.add(book);
		newBook(book.getTiltle());
	}
	
	public void addObserver(Observer o) {
		observer.add(o);
	}
	
	public void removeObserver (Observer o) {
		observer.remove(o);
	}
	
	private void newBook(String bookName) {
		for (Observer o : observer) {
			o.update( "New book available: " + bookName);
		}
	}
}
