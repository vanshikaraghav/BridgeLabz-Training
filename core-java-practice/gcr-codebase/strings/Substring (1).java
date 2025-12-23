package strings;
import java.util.Scanner;

public class Substring {
	
	public static String substringUsingCharAt(String text, int start, int end) {
        String result = "";
        for (int i = start; i < end; i++) {
            result += text.charAt(i);
        }
        return result;
    }

    public static boolean compareStrings(String a, String b) {
        if (a.length() != b.length()) return false;

        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.next();
        System.out.print("start index: ");
        int start = sc.nextInt();
        System.out.print("end index: ");
        int end = sc.nextInt();
        String userDefinedSub = substringUsingCharAt(text, start, end);
        String builtInSub = text.substring(start, end);
        System.out.println("Substring using charAt(): " + userDefinedSub);
        System.out.println("Substring using substring(): " + builtInSub);
        System.out.println("Both are equal: " + compareStrings(userDefinedSub, builtInSub));
    }

}
