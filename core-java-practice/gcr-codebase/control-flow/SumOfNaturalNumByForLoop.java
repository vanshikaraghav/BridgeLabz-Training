package control_flow;
import java.util.Scanner;

public class SumOfNaturalNumByForLoop {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int sum1 = 0;
		int sum =0;
		if(n>0) {
			System.out.println("Natural number");
			sum = n*(n+1)/2;
			for(int i=1;i<=n;i++) {
				sum1 += i;
			}
		}
		System.out.println("The sum of n natural number using formula is "+sum);
		System.out.println("The sum of n natural number using for loop is "+sum1);
		if(sum == sum1) {
			System.out.println("The sum is same by both approach");
		}else {
			System.out.println("The sum is not same");
		}
	}
}
