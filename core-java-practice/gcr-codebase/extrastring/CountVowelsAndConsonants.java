package extra;
import java.util.Scanner;

public class CountVowelsAndConsonants {
	
	public static String countCharacterType(char ch) {
		if (ch >= 'A' && ch <= 'Z') {
            ch = (char)(ch + 32);
        }
        if (ch >= 'a' && ch <= 'z') {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                return "Vowel";
            } else {
                return "Consonant";
            }
        }
		return null;
        
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int vowelCount = 0;
        int consonantCount = 0;
        for (int i = 0; i < str.length(); i++) {
            String type = countCharacterType(str.charAt(i));
            if (type.equals("Vowel")) {
                vowelCount++;
            } else if (type.equals("Consonant")) {
                consonantCount++;
            }
        }
        System.out.println("Vowels: " + vowelCount);
        System.out.println("Consonants: " +consonantCount);
	}

}
