package constructors_and_variables;

class Book {

    public String ISBN;
    protected String title;
    private String author;

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }
}

class EBook extends Book {
    void displayBookDetails() {
        System.out.println("ISBN: " +ISBN+" | Title: "+title+" | Author: "+getAuthor());
    }
}

public class BookLibrarySystem {
    public static void main(String[] args) {
        EBook ebook = new EBook();
        ebook.ISBN = "101";
        ebook.title = "2States";
        ebook.setAuthor("Chetan Bhagat");
        ebook.displayBookDetails();
    }
}
