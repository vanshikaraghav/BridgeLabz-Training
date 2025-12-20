package control_flow;

import java.util.Scanner;

public class CanVoteOrNot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int age = sc.nextInt();
		if(age>=18) {
			System.out.println("The person can vote");
		}else {
			System.out.println("The person cannot vote");
		}
	}

}
