package control_flow;
import java.util.Scanner;

public class FactorByWhileLoop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		if(number>0) {
			System.out.println("positive number");
			int i=1;
			while(i<number) {
				if(number%i==0) {
					System.out.println(i);
					i++;
				}
			}
		}
	}
}
