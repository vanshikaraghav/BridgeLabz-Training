package control_flow;
import java.util.Scanner;

public class SwitchCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        double first = sc.nextDouble();
        double second = sc.nextDouble();
        String operation = sc.next();
        switch (operation) {
            case "+":
                System.out.println("Result: " + (first+second));
                break;
            case "-":
                System.out.println("Result: " + (first-second));
                break;
            case "*":
                System.out.println("Result: " + (first*second));
                break;
            case "/":
                if (second != 0) {
                    System.out.println("Result: " + (first/second));
                } else {
                    System.out.println("Division by zero not allowed");
                }
                break;
            default:
                System.out.println("Invalid Operator");
        }
	}

}
