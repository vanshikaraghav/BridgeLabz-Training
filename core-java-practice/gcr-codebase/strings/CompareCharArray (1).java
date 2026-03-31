package strings;
import java.util.Scanner;

public class CompareCharArray {
	
	public static char[] getCharsUsingCharAt(String text) {
        char[] arr = new char[text.length()];
        for (int i=0;i<text.length();i++) {
            arr[i] = text.charAt(i);
        }
        return arr;
    }

    public static boolean compareCharArrays(char[] str1, char[] str2) {
        if (str1.length != str2.length) {
        	return false;
        }
        for (int i=0;i<str1.length;i++) {
            if (str1[i]!=str2[i]) {
            	return false;
            }
        }
        return true;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String text = sc.next();
		char[] userDefinedArray = getCharsUsingCharAt(text);
	    char[] builtInArray = text.toCharArray();
	    System.out.println(compareCharArrays(userDefinedArray, builtInArray));
	}

}
