package strings;
import java.util.Scanner;

public class StringIndexOutOfBoundsExceptionDemo {
	
    static void handleException(String text) {
        try {
            System.out.println(text.charAt(100));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("StringIndexOutOfBoundsException handled");
        }
    }

    public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        String text = sc.next();
        handleException(text);
    }

}
