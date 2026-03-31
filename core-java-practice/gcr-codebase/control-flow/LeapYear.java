package control_flow;
import java.util.Scanner;

public class LeapYear {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        if(year<1582) {
            System.out.println("Year should be 1582 or later");
        } 
        else if(year%400==0) {
            System.out.println("Leap Year");
        } 
        else if(year%100==0) {
            System.out.println("Not a Leap Year");
        } 
        else if(year%4==0) {
            System.out.println("Leap Year");
        } 
        else {
            System.out.println("Not a Leap Year");
        }
	}

}
