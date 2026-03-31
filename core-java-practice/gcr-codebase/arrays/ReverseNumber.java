package arrays;
import java.util.Scanner;

public class ReverseNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int temp = number;
        int count = 0;
        while (temp!=0) {
            count++;
            temp /= 10;
        }
        int[] digits = new int[count];
        int index = 0;
        while (number!=0) {
            digits[index++] = number%10;
            number /= 10;
        }
        for (int i=0;i<count;i++) {
            System.out.print(digits[i]);
        }
	}

}
