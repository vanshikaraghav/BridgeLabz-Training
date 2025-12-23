package strings;

import java.util.Scanner;

public class TrimString {
	
	public static int[] findTrimIndexes(String text) {
        int start = 0;
        int end = text.length() - 1;
        while (text.charAt(start) == ' ') {
            start++;
        }
        while (text.charAt(end) == ' ') {
            end--;
        }
        return new int[]{start, end};
    }

    public static String manualSubstring(String text, int start, int end) {
        String result = "";
        for (int i = start; i <= end; i++) {
            result += text.charAt(i);
        }
        return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        int[] index = findTrimIndexes(text);
        String trimmed = manualSubstring(text, index[0], index[1]);
        System.out.println("UserDefined Trim : '" + trimmed + "'");
        System.out.println("Built-in Trim: '" + text.trim() + "'");
	}

}
