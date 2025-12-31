package class_and_objects;

public class PallindromeChecker {
	
	String text;

    boolean isPallindrome() {
        String text1 = text.replaceAll("\\s+", "").toLowerCase();
        String reverse = "";
        int length = text1.length()-1;
        for(int i = length;i>=0;i--) {
            reverse = reverse+text1.charAt(i);
        }
        return text1.equals(reverse);
    }

    void displayResult() {
        if(isPallindrome()) {
            System.out.println(text+" is pallindrome");
        }else {
            System.out.println(text+" is not Pallindrome");
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PallindromeChecker str1 = new PallindromeChecker();
        str1.text = "A man a plan a canal Panama";
        PallindromeChecker str2 = new PallindromeChecker();
        str2.text = "Hello";
        str1.displayResult();
        str2.displayResult();
	}

}
