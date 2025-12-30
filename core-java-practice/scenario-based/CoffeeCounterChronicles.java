package scenario_based;
import java.util.Scanner;

public class CoffeeCounterChronicles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        final double gst = 0.18; 
        while (true) {
            System.out.print("Enter coffee type (Cappuccino/Espresso/Latte) or exit");
            String coffeeType = sc.nextLine();
            if(coffeeType.equalsIgnoreCase("exit")) {
                System.out.println("Wait for Bills");
                break;
            }
            System.out.print("Please enter quantity for coffee");
            int quantity = sc.nextInt();
            double price = 0;
            switch (coffeeType.toLowerCase()) {
                case "cappuccino":
                    price = 170;
                    break;
                case "espresso":
                    price = 120;
                    break;
                case "latte":
                    price = 150;
                    break;
                default:
                    System.out.println("Invalid coffee type");
                    continue;
            }
            double total = price * quantity;
            double gstNew = total * gst;
            double Bill = total + gstNew;
            System.out.println("Total (without GST): ₹" + total);
            System.out.println("GST: ₹" + gstNew);
            System.out.println("Final Bill (including GST) : ₹" + Bill);
        }
	}

}
