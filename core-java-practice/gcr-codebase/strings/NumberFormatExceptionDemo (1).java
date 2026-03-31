package strings;
import java.util.Scanner;

public class NumberFormatExceptionDemo {
	
	static void handleException(String text) {
        try {
            int num = Integer.parseInt(text);
            System.out.println("Number: " + num);
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException handled");
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        String text = sc.next();
        handleException(text);
	}

}
