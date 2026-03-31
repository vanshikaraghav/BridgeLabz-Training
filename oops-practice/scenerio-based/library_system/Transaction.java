package library_system;

public class Transaction {
	Book book;
    Member member;

    Transaction(Book book, Member member) {
        this.book = book;
        this.member = member;
    }

    void issueBook() throws BookNotAvailableException {
        if (!book.isAvailable) {
            throw new BookNotAvailableException("Book already issued");
        }
        book.isAvailable = false;
        System.out.println("Book issued to " + member.name);
    }

    void returnBook(int daysLate) {
        book.isAvailable = true;
        System.out.println("Book returned");
        System.out.println("Fine: " + member.calculateFine(daysLate));
    }
}
