package regex;
import java.util.Scanner;

public class ValidIPAddress {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter IP Address: ");
        String ip = sc.nextLine();
        String regex =
                "^((25[0-5]|2[0-4][0-9]|1?[0-9]{1,2})\\.){3}" +
                "(25[0-5]|2[0-4][0-9]|1?[0-9]{1,2})$";
        if(ip.matches(regex)) {
            System.out.println("Valid IP Address");
        }else {
            System.out.println("Invalid IP Address");
        }
    }
}
