package built_in_Functions;

import java.util.Scanner;

public class FactorialByRecursion {
	
	public static int factorial(int n) {
        if (n==0 || n==1) {
        	return 1;
        }
        return n*factorial(n-1);
    }

    public static void displayResult(int num, int result) {
        System.out.println("Factorial of " + num + " is " + result);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int result = factorial(num);
		displayResult(num, result);
	}

}
