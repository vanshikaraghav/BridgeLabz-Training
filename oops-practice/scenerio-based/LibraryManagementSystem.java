package scenario_based;

public class LibraryManagementSystem {

    static String[] titles = {"Java Basics", "2States", "Wings Of Fire"};
    static String[] authors = {"James", "Chetan Bhagat", "A.P.J. Abdul Kalam"};
    static boolean[] available = {true, true, true};

    public static void main(String[] args) {
        displayBooks();
        searchBook("Java");
        checkoutBook("Java Basics");
        displayBooks();
    }

    static void displayBooks() {
        System.out.println("Library Books:");
        for(int i=0;i<titles.length;i++) {
            System.out.println(titles[i]+" : "+authors[i] +" : "+(available[i] ? "Available" : "Checked Out"));
        }
    }

    static void searchBook(String keyword) {
        System.out.println("\nSearch Results:");
        for(int i=0;i<titles.length;i++) {
            if(titles[i].toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(titles[i]);
            }
        }
    }

    static void checkoutBook(String title) {
        for(int i=0;i<titles.length;i++) {
            if(titles[i].equalsIgnoreCase(title) && available[i]) {
                available[i] = false;
                System.out.println("\nBook checked out: "+title);
                return;
            }
        }
        System.out.println("\nBook not available.");
    }

}
