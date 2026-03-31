package extra;
import java.util.Scanner;

public class SubstringOccurence {
	
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
		String str = sc.nextLine();
	    System.out.println("Enter substring to search:");
	    String subStr = sc.nextLine();
	    int len = getLength(str);
	    int subLen = getLength(subStr);
	    int count = 0;
	    for(int i=0;i<=len-subLen;i++) {
	        boolean match = true;
	        for(int j=0;j<subLen;j++) {
	             if(str.charAt(i+j)!=subStr.charAt(j)) {
	                 match = false;
	                 break;
	             }
	         }
	         if(match) {
	        	 count++;
	         }
	     }
	     System.out.println("Occurrences of substring: "+count);
	}

}
