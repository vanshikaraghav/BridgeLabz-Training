package built_in_Functions;
import java.time.LocalDate;
import java.util.Scanner;

public class DateComparison {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        String input1 = sc.nextLine();
        String input2 = sc.nextLine();
        LocalDate date1 = LocalDate.parse(input1);
        LocalDate date2 = LocalDate.parse(input2);
        if(date1.isBefore(date2)) {
           System.out.println("First date is before the second date.");
        }else if(date1.isAfter(date2)) {
            System.out.println("First date is after the second date.");
        }else if(date1.isEqual(date2)) {
            System.out.println("Both dates are the same.");
        }
	}

}
