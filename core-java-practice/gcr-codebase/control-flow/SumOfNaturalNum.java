package control_flow;

import java.util.Scanner;

public class SumOfNaturalNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int sum1 = 0;
		int sum =0;
		if(n>0) {
			System.out.println("Natural number");
			sum = n*(n+1)/2;
			int i = 1;
			while(i<=n) {
				sum1 += i;
				i++;
			}
		}
		System.out.println("The sum of n natural number using formula is "+sum);
		System.out.println("The sum of n natural number using while loop is "+sum1);
		if(sum == sum1) {
			System.out.println("The sum is same by both approach");
		}else {
			System.out.println("The sum is not same");
		}
	}

}
