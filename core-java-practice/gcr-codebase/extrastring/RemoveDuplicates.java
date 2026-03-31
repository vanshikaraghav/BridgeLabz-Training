package extra;
import java.util.Scanner;

public class RemoveDuplicates {
	
	public static boolean isValid(String str,int index) {
	     return index >= 0 && index < str.length();
	 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
	     int len = 0;
	     while(true) {
	         if(isValid(str,len)) {
	        	 len++;
	         }else {
	        	 break;
	         }
	     }
	     String result = "";
	     for(int i=0;i<len;i++) {
	         char current = str.charAt(i);
	         boolean duplicate = false;
	         for(int j=0;j<i;j++) {
	             if(str.charAt(j)==current) {
	                 duplicate = true;
	                 break;
	             }
	         }
	         if(!duplicate) {
	        	 result += current;
	         }
	     }
	     System.out.println("String after removing duplicates: " + result);
	}

}
