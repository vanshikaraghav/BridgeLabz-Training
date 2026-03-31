package methods;
import java.util.Scanner;

public class QuotientAndRemainder {
	
	public static int[] findRemainderAndQuotient(int number, int divisor) {
		int quotient = number/divisor;
        int remainder = number%divisor;
        return new int[]{quotient, remainder};
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		int divisor = sc.nextInt();
		int[] ans = findRemainderAndQuotient(number, divisor);
		System.out.println("Quotient is: "+ans[0]);
		System.out.println("Remainder is: "+ans[1]);
	}

}
