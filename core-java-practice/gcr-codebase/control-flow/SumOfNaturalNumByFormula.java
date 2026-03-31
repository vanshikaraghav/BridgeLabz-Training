package control_flow;

import java.util.Scanner;

public class SumOfNaturalNumByFormula {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int sum =0;
		if(n>0) {
			System.out.println("Natural number");
			sum = n*(n+1)/2;
			System.out.println("The sum of "+n+" natural numbers is "+sum);
		}else {
			System.out.println("The number "+n+" is not natural");
		}

	}

}
