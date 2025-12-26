package methods;
import java.util.Scanner;

public class NoOfRounds {
	
	public static double calculateRounds(double side1,double side2,double side3) {
		double perimeter = side1+side2+side3;
		double rounds = 5000/perimeter;
		return rounds;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		double side1 = sc.nextDouble();
		double side2 = sc.nextDouble();
		double side3 = sc.nextDouble();
		double result = calculateRounds(side1, side2, side3);
		System.out.println("The rounds the athelete has to complete is "+result);
	}

}
