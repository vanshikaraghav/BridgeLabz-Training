package scenario_based;
import java.util.Scanner;

public class SentenceFormatter {
	
	public static String formatSentence(String str) {
		String str1 = str.trim().replaceAll("\\s+", " ");
		String str2 = str1.replaceAll("\\s*([.,!?])\\s*", "$1 ");
		String[] str4 = str2.split(".?!");
	    StringBuilder sb = new StringBuilder();
	    for(String s : str4) {
	        sb.append(Character.toUpperCase(s.charAt(0))+s.substring(1)).append(" ");
	    }
	    return sb.toString().trim();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String result = formatSentence(str);
		System.out.println(result);
	}

}
