package library_system;

public class BookNotAvailableException extends Exception{
	public BookNotAvailableException(String message) {
		super(message);
	}
}
