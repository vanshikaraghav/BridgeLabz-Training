package strings;
import java.util.Scanner;

public class ToLowerCase {
	
	public static String toLowerByCharAt(String text) {
        String result = "";

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                ch = (char) (ch - 32);
            }
            result += ch;
        }
        return result;
    }

    public static boolean compare(String str1, String str2) {
        if (str1.length() != str2.length()) return false;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
	// TODO Auto-generated method stub
	Scanner sc = new Scanner(System.in);
    String text = sc.nextLine();
    String userDefined = toLowerByCharAt(text);
    String builtIn = text.toLowerCase();
    System.out.println("Same result: " + compare(userDefined, builtIn));
    }

}
