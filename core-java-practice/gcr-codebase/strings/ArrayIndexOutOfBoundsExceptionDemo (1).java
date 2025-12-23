package strings;
import java.util.Scanner;

public class ArrayIndexOutOfBoundsExceptionDemo {
	
	static void handleException(String[] names) {
        try {
            System.out.println(names[10]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException handled");
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        String[] names = new String[3];
        for (int i=0;i<names.length;i++) {
            names[i] = sc.next();
        }
        handleException(names);
	}

}
