package control_flow;

import java.util.Scanner;

public class FactorialByWhileLoop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if(n>0) {
			System.out.println("Positive number");
		}
		int i=1;
		int factorial = i; 
		while(i<=n) {
			factorial *= i;
			i++;
		}
		System.out.println(factorial);
	}

}
