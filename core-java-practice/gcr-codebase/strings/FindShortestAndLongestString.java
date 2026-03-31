package strings;
import java.util.Scanner;

public class FindShortestAndLongestString {
	
	public static String[] splitWords(String text) {
        int count = 1;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ')
                count++;
        }
        String[] words = new String[count];
        int index = 0;
        String temp = "";

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                words[index++] = temp;
                temp = "";
            } else {
                temp += text.charAt(i);
            }
        }
        words[index] = temp;
        return words;
    }

    public static int findLength(String s) {
        int c = 0;
        try {
            while (true) {
                s.charAt(c++);
            }
        } catch (Exception e) {}
        return c;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String[] words = splitWords(text);
        String shortest = words[0];
        String longest = words[0];
        for (String word : words) {
            if (findLength(word) < findLength(shortest))
                shortest = word;
            if (findLength(word) > findLength(longest))
                longest = word;
        }
        System.out.println("Shortest word: " + shortest);
        System.out.println("Longest word : " + longest);

	}

}
