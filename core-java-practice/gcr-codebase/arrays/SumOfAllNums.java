package arrays;
import java.util.Scanner;

public class SumOfAllNums {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[10];
        int total = 0;
        int index = 0;
        while (true) {
            int number = sc.nextInt();
            if (number <= 0 || index == 10) {
                break;
            }
            arr[index] = number;
            index++;
        }
        for (int i = 0; i < index; i++) {
            System.out.println(arr[i]);
            total += arr[i];
        }
        System.out.println(total);
	}
}
