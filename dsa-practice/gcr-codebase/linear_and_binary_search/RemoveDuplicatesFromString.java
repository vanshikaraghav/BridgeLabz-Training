package linear_and_binary_search;
import java.util.Scanner;
import java.util.HashSet;

public class RemoveDuplicatesFromString {
    public static String removeDuplicates(String input) {
        StringBuilder result = new StringBuilder();
        HashSet<Character> seen = new HashSet<>();
        for(int i=0;i<input.length();i++) {
            char ch = input.charAt(i);
            if(!seen.contains(ch)) {
                result.append(ch);
                seen.add(ch);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String original = sc.nextLine();
        String withoutDuplicates = removeDuplicates(original);
        System.out.println("Original: " + original);
        System.out.println("Without duplicates: " + withoutDuplicates);
    }
}