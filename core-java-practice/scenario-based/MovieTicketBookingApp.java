package scenario_based;
import java.util.Scanner;

public class MovieTicketBookingApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        char choice;
        do{
           System.out.print("Enter movie type (1-Horror, 2-Comedy, 3-Action): ");
           int movieType = sc.nextInt();
           System.out.print("Seat type (gold/silver): ");
           String seatType = sc.next();
           System.out.print("Want snacks? (yes/no): ");
           String snacks = sc.next();
           int price = 0;
           switch(movieType) {
                case 1:
                    price = 200;
                    break;
                case 2:
                    price = 150;
                    break;
                case 3:
                	price = 100;
                	break;
                default:
                    System.out.println("Invalid movie type");
            }
            if(seatType.equalsIgnoreCase("gold")) {
                price += 100;
            }else {
                price += 50;
            }
            if(snacks.equalsIgnoreCase("yes")) {
                price += 80;
            }
            System.out.println("Total Ticket Price: ₹" + price);
            System.out.print("Next customer? (y/n): ");
            choice = sc.next().charAt(0);
        } while(choice=='y');
	}

}
