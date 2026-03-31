package control_flow;

import java.util.Scanner;

public class FactorialByForLoop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int factorial = 1;
		if(n>0) {
			System.out.println("Positive number");
		}
		for(int i=1;i<=n;i++) {
			factorial *= i;
		}
		System.out.println(factorial);
	}

}
