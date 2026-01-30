package regex;
import java.util.Scanner;

public class ValidLisencePlate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter license plate: ");
        String plate = sc.nextLine();
        if(plate.matches("^[A-Z]{2}[0-9]{4}$")) {
            System.out.println("Valid License Plate");
        }else {
            System.out.println("Invalid License Plate");
        }
    }
}
