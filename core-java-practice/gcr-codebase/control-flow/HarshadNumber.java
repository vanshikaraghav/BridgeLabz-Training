package control_flow;
import java.util.Scanner;

public class HarshadNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner sc = new Scanner(System.in);
	        int number = sc.nextInt();
	        int sum = 0;
	        int temp = number;
	        while (temp != 0) {
	            int digit = temp % 10;
	            sum = sum + digit;
	            temp = temp / 10;
	        }
	        if (number % sum == 0) {
	            System.out.println("Harshad Number");
	        } else {
	            System.out.println("Not a Harshad Number");
	        }
	}

}
