package control_flow;
import java.util.Scanner;

public class CountDigits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner sc = new Scanner(System.in);
	        int number = sc.nextInt();
	        int count = 0;
	        while (number!=0) {
	            number = number/10; 
	            count++;
	        }
	}

}
