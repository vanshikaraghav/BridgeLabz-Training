package control_flow;

import java.util.Scanner;

public class BiggestOfThree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int firstNum = sc.nextInt();
		int secondNum = sc.nextInt();
		int thirdNum = sc.nextInt();
		if(firstNum>secondNum && firstNum>thirdNum) {
			System.out.println("Is the first number the largest? Yes");
		}else if(secondNum>firstNum && secondNum>thirdNum){
			System.out.println("Is the second number the largest? Yes");
		}else {
			System.out.println("Is the third number the largest? Yes");
		}
	}

}
