package control_flow;

import java.util.Scanner;

public class SumTotalTillZero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int value = sc.nextInt();
		double total = 0.0;
		while(value!=0) {
			total += value;
			value = sc.nextInt();
		}
		System.out.println(total);
	}

}
