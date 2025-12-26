package extra;
import java.util.Scanner;

public class ReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int len = 0;
	    while (len<str.length()) {
	    	 len++;
	     }
	     System.out.print("Reversed string: ");
	     for(int i=len-1;i>=0;i--) {
	         System.out.print(str.charAt(i));
	     }
	     System.out.println();
	}

}
