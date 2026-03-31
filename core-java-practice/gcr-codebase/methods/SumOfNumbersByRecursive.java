package methods;
import java.util.Scanner;

public class SumOfNumbersByRecursive {
	
	public static int sumofNnumbers(int n) {
		int sum = n*(n+1)/2;
		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int sum = sumofNnumbers(n);
		System.out.println(sum);
	}

}
