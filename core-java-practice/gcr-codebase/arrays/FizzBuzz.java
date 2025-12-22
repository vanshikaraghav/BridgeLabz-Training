package arrays;
import java.util.Scanner;

public class FizzBuzz {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        if (number<=0) {
            System.out.println("Not a positive number");
            return;
        }
        String[] result = new String[number + 1];
        for (int i=1;i<=number;i++) {
            if(i%3==0 && i%5==0) {
                result[i] = "FizzBuzz";
            } else if(i%3==0) {
                result[i] = "Fizz";
            } else if(i%5==0) {
                result[i] = "Buzz";
            } else {
                result[i] = Integer.toString(i);
            }
        }
        for (int i=1;i<=number;i++) {
            System.out.println("Position " + i + " = " + result[i]);
        }
	}

}
