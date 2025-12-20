package control_flow;

import java.util.Scanner;

public class DivisibleByFive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		if(num%5==0) {
			System.out.println("Is the number "+num+" is divisible by 5?"+ " YES");
		}else {
			System.out.println("Is the number "+num+" is divisible by 5?"+ "NO");
		}
	}

}
