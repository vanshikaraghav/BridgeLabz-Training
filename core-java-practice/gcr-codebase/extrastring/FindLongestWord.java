package extra;
import java.util.Scanner;

public class FindLongestWord {
	
	public static int getLength(String s) {
	     int count = 0;
	     while(true) {
	         if(count>=s.length()) {
	        	 break;
	         }
	         s.charAt(count); 
	         count++;
	     }
	     return count;
	 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int len = getLength(str);
		String word = "", longest = "";
	    for(int i=0;i<=len;i++) {
	        char ch = (i==len) ? ' ' : str.charAt(i);
	         if(ch == ' ') {
	             if(getLength(word)>getLength(longest)) {
	                 longest = word;
	             }
	             word = "";
	         }else {
	             word += ch;
	         }
	     }
	     System.out.println("Longest word: " + longest);
	}

}
