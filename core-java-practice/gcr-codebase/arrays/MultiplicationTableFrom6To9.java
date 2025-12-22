package arrays;
import java.util.Scanner;

public class MultiplicationTableFrom6To9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int[] table = new int[10];
        for (int i = 6; i <= 9; i++) {
            table[i - 1] = number * i;
        }
        for (int i = 6; i <= 9; i++) {
            System.out.println(number + " * " + i + " = " + table[i - 1]);
        }
	}

}
