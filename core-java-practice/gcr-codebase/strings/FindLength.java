package strings;
import java.util.Scanner;

public class FindLength {

	public static int findLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (Exception e) {
        }
        return count;
    }

    public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        String text = sc.next();
        System.out.println("User-defined Length  : " + findLength(text));
        System.out.println("Built-in Length: " + text.length());
	}

}
