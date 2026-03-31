package regex;
import java.util.Scanner;

public class ValidUsername {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = sc.nextLine();
        String regex = "^[A-Za-z][A-Za-z0-9_]{4,14}$";
        if(username.matches(regex)) {
            System.out.println("Valid Username");
        }else {
            System.out.println("Invalid Username");
        }
    }
}
