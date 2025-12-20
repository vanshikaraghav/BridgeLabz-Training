package control_flow;

import java.util.Scanner;

public class SpringSeason {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int month = sc.nextInt();
		int day = sc.nextInt();
		boolean isSpring = (month == 3 && day >= 20) || (month==4) || (month==5) || (month==6 && day<=20);
		if(isSpring) {
			System.out.println("Spring Season");
		}else {
			System.out.println("Not Spring Season");
		}
	}

}
