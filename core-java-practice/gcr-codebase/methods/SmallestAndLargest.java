package methods;
import java.util.Scanner;

public class SmallestAndLargest {
	
	public static int[] findSmallestAndLargest(int number1, int number2, int number3) {
		int smallestNum = number1;
        int largestNum = number1;
        if (number2 < smallestNum) {
        	smallestNum = number2;
        }
        if (number3 < smallestNum) {
        	smallestNum = number3;
        }
        if (number2 > largestNum) {
        	largestNum = number2;
        }
        if (number3 > largestNum) {
        	largestNum = number3;
        }
        return new int[]{smallestNum, largestNum};
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int number1 = sc.nextInt();
		int number2 = sc.nextInt();
		int number3 = sc.nextInt();
		int[] ans = findSmallestAndLargest(number1, number2, number3);
		System.out.println("smallest is: "+ans[0]);
		System.out.println("largest is: "+ans[1]);
	}

}
