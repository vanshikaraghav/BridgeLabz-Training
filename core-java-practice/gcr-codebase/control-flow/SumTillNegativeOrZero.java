package control_flow;

import java.util.Scanner;

public class SumTillNegativeOrZero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		double total = 0.0;
		while(true) {
			int value = sc.nextInt();
			if(value<=0) {
				break;
			}
			total += value;
		}
		System.out.println(total);
	}

}
