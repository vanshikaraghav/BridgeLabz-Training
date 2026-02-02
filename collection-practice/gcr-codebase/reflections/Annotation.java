package reflections;

public class Annotation {
    public static void main(String[] args) {
        Class<Book> cls = Book.class;
        Author author = cls.getAnnotation(Author.class);
        System.out.println("Author Name: " + author.name());
    }
}