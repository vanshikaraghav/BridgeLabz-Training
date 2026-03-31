package control_flow;

import java.util.Scanner;

public class CountDownByForLoop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int counter = sc.nextInt();
		for(int i=counter;i>=1;i--) {
			System.out.println(i);
		}
	}

}
