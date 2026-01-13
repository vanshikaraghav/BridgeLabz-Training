package library_system;

public class LibraryManagementSystem {
	public static void main(String[] args) {
        Book b1 = new Book(1, "Java Programming");
        Member m1 = new Member(101, "Harshita", "Student");
        Transaction t1 = new Transaction(b1, m1);
        try {
            t1.issueBook();
            t1.returnBook(3);
        } catch (BookNotAvailableException e) {
            System.out.println(e.getMessage());
        }
    }
}
