package scenerio_based;

class Bookk {
    String title;

    Bookk(String title) {
        this.title = title;
    }
}

class SmartShelf {
    Bookk[] books = new Bookk[10];
    int count = 0;

    void addBook(String title) {
        books[count] = new Bookk(title);
        count++;
        insertionSort();
    }

    void insertionSort() {
        for (int i = 1; i < count; i++) {
            Bookk key = books[i];
            int j = i - 1;

            while (j >= 0 && books[j].title.compareToIgnoreCase(key.title) > 0) {
                books[j + 1] = books[j];
                j--;
            }
            books[j + 1] = key;
        }
    }

    void displayBooks() {
        System.out.println("SmartShelf Order:");
        for (int i = 0; i < count; i++) {
            System.out.println(books[i].title);
        }
    }
}

public class SmartShelfSystem {
	public static void main(String[] args) {
        SmartShelf shelf = new SmartShelf();
        shelf.addBook("Data Structures");
        shelf.addBook("Algorithms");
        shelf.addBook("Computer Networks");
        shelf.addBook("Artificial Intelligence");

        shelf.displayBooks();
    }
}
