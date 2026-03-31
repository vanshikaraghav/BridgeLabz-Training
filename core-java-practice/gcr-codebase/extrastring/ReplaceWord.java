package extra;
import java.util.Scanner;

public class ReplaceWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
	    System.out.println("Enter the sentence:");
	    String sentence = sc.nextLine();
	    System.out.println("Enter the word to replace:");
	    String target = sc.nextLine();
	    System.out.println("Enter the new word:");
	    String replacement = sc.nextLine();
	    int len1 = sentence.length();
	    int len2 = target.length();
	    String result = "";
	    int i = 0;
	    while(i<=len1-len2) {
	         boolean match = true;
	         for(int j=0;j<len2;j++) {
	             if(sentence.charAt(i+j)!=target.charAt(j)) {
	                 match = false;
	                 break;
	             }
	         }
	         if(match && (i+len2==len1 || sentence.charAt(i+len2)== ' ')) {
	             result += replacement;
	             i += len2;
	         }else {
	             result += sentence.charAt(i);
	             i++;
	         }
	     }
	     while(i<len1) {
	         result += sentence.charAt(i);
	         i++;
	     }
	     System.out.println("Modified sentence: " + result);
	}

}
