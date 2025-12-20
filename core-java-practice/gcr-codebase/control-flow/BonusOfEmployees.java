package control_flow;

import java.util.Scanner;

public class BonusOfEmployees {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int yearOfService = sc.nextInt();
		double salary = sc.nextDouble();
		double bonus = 0;
		if(yearOfService > 5) {
			bonus = salary*0.05;
		}
		System.out.println(bonus);
	}

}
