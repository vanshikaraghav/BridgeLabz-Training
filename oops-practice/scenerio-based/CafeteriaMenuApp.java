package scenario_based;
import java.util.Scanner;

public class CafeteriaMenuApp {
	
	static void displayMenu(String[] items) {
		System.out.println("Cafeteria Menu\n");
        for(int i = 0; i < items.length; i++) {
        System.out.println(i + " : " + items[i]);
        }
	}

    static String getItemByIndex(String[] items, int index) {
        if(index < 0 || index >= items.length) {
        	return "Invalid item selection";
        }
        return items[index];
    }

    public static void main(String[] args) {
    	String[] menuItems = {"Idli", "Dosa", "Vada", "Pasta", "Burger","Sandwich", "Pizza", "Noodles", "Coffee", "Tea\n"};
        Scanner sc = new Scanner(System.in);
        displayMenu(menuItems);
        System.out.print("Select item index: ");
        int choice = sc.nextInt();
        String selectedItem = getItemByIndex(menuItems, choice);
        System.out.println("Selected Item: " + selectedItem);
        sc.close();
    }
}
