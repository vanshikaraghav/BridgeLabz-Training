package methods;
import java.util.Scanner;

public class SumOfNaturalNumbers {
	
	public static int sum(int n) {
		int sum=0;
		for(int i=1;i<n;i++) {
			sum += i;
		}
		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int result = sum(n);
		System.out.println(result);
	}

}
