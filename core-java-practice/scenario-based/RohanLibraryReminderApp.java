package scenario_based;
import java.util.Scanner;

public class RohanLibraryReminderApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        for(int i=1;i<=5;i++) {
            System.out.println("Book "+i);
            System.out.print("Enter due date (day): ");
            int dueDate = sc.nextInt();
            System.out.print("Enter return date (day): ");
            int returnDate = sc.nextInt();
            if(returnDate>dueDate) {
                int lateDays = returnDate-dueDate;
                int fine = lateDays*5;
                System.out.println("Late by "+lateDays+" days. Fine: ₹"+fine);
            }else {
                System.out.println("Returned on time. No fine.");
            }
        }
	}

}
