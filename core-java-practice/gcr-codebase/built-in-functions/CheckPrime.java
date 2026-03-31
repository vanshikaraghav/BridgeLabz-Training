package built_in_Functions;
import java.util.Scanner;

public class CheckPrime {
	
	public static boolean isPrime(int num) {
        if(num<=1) {
        	return false;
        }
        for(int i=2;i*i<=num;i++) {
            if(num%i==0) {
            	return false;
            }
        }
        return true;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		if(isPrime(num)) {
			System.out.println("Prime no.");
		}else {
			System.out.println("Not a prime no.");
		}
	}

}
