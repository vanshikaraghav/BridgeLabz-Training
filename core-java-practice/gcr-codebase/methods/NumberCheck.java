package methods;
import java.util.Scanner;

public class NumberCheck {
	
	public static int checkNum(int n) {
		if(n<0) {
			return -1;
		}else if(n>0) {
			return 1;
		}else {
			return 0;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int numType = checkNum(n);
		System.out.println(numType);
	}

}
