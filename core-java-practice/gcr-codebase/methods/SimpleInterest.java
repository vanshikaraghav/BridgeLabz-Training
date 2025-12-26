package methods;
import java.util.Scanner;

public class SimpleInterest {
	
	public static int calculateSI(int principal,int rate,int time) {
		int simpleInterest = (principal*rate*time)/100;
		return simpleInterest;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int principal = sc.nextInt();
		int rate = sc.nextInt();
		int time = sc.nextInt();
		double interest = calculateSI(principal, rate, time);
		System.out.println("The Simple Interest is "+interest+" for Principal "+principal+", Rate of Interest "+rate+", time is "+time);
	}

}
