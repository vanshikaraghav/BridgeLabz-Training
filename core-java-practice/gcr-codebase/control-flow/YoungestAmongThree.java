package control_flow;

import java.util.Scanner;

public class YoungestAmongThree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("enter age of amar,akbar,anthony:");
		int amarAge = sc.nextInt();
		int akbarAge = sc.nextInt();
		int anthonyAge = sc.nextInt();
		System.out.println("enter height of amar,akbar,anthony:");
		int amarHeight = sc.nextInt();
		int akbarHeight = sc.nextInt();
		int anthonyHeight = sc.nextInt();
		if(amarAge<akbarAge && amarAge<anthonyAge) {
			System.out.println("Amar is youngest");
		}else if(akbarAge<amarAge && akbarAge<anthonyAge) {
			System.out.println("Akbar is youngest");
		}else {
			System.out.println("Anthony is youngest");
		}
		if(amarHeight>akbarHeight && amarHeight>anthonyHeight) {
			System.out.println("Amar is tallest");
		}else if(akbarHeight>amarHeight && akbarHeight>anthonyHeight) {
			System.out.println("Akbar is tallest");
		}else {
			System.out.println("Anthony is tallest");
		}
	}

}
