package regex;
import java.util.Scanner;

public class ValidSSN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter SSN: ");
        String ssn = sc.nextLine();
        String regex = "^\\d{3}-\\d{2}-\\d{4}$";
        if(ssn.matches(regex)) {
            System.out.println("Valid SSN");
        }else {
            System.out.println("Invalid SSN");
        }
    }
}
