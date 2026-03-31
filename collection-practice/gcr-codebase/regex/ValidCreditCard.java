package regex;
import java.util.Scanner;

public class ValidCreditCard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Credit Card Number: ");
        String card = sc.nextLine();
        String visaRegex = "^4\\d{15}$";
        String masterRegex = "^5\\d{15}$";
        if(card.matches(visaRegex)) {
            System.out.println("Valid Visa Card");
        }else if(card.matches(masterRegex)) {
            System.out.println("Valid MasterCard");
        }else {
            System.out.println("Invalid Credit Card");
        }
    }
}

