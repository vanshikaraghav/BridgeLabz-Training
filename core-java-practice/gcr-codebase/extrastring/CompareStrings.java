package extra;
import java.util.Scanner;

public class CompareStrings {
	
	public static int getLength(String s) {
	    int i = 0;
	    while(i<s.length()) {
	    	 i++;
	     }
	     return i;
	 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str1 = sc.next();
		String str2 = sc.next();
		int len1 = getLength(str1);
	    int len2 = getLength(str2);
	    int min = (len1<len2) ? len1 : len2;
	    int result = 0;
	    for(int i=0;i<min;i++) {
	        char c1 = str1.charAt(i);
	        char c2 = str2.charAt(i);
	        if(c1!=c2) {
	            result =(c1<c2) ? -1 : 1;
	            break;
	         }
	     }
	     if(result==0 && len1!=len2) {
	        result = (len1<len2) ? -1 : 1;
	     }
	     if(result<0) {
	        System.out.println("\"" + str1 + "\" comes before \"" + str2 + "\"");
	     }else if(result>0) {
	         System.out.println("\"" + str2 + "\" comes before \"" + str1 + "\"");
	     } else {
	         System.out.println("Both strings are equal.");
	     }
	}

}
