package strings;
import java.util.Scanner;

public class IllegalArgumentExceptionDemo {

	static void handleException(String text) {
        try {
            System.out.println(text.substring(5, 2));
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException handled");
        }
    }

    public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        String text = sc.next();
        handleException(text);
	}

}
