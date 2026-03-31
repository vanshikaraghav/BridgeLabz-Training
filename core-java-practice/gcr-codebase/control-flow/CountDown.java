package control_flow;

import java.util.Scanner;

public class CountDown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int counter = sc.nextInt();
		while(counter>=1) {
			System.out.println(counter);
			counter--;
		}
	}

}
