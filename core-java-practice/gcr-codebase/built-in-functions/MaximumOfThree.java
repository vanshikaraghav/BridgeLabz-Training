package built_in_Functions;
import java.util.Scanner;

public class MaximumOfThree {
	
	public static int readInteger(Scanner sc) {
        return sc.nextInt();
    }

    public static int findMax(int firstNum, int secondNum, int thirdNum) {
        int max = firstNum;
        if(secondNum>max) {
        	max = secondNum;
        }
        if(thirdNum>max) {
        	max = thirdNum;
        }
        return max;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int firstNum  = sc.nextInt();
		int secondNum = sc.nextInt();
		int thirdNum = sc.nextInt();
		int max = findMax(firstNum, secondNum, thirdNum);
		System.out.println("The maximum of three is: "+max);
	}

}
