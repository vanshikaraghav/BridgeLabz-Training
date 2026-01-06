import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        int end = s.length() - 1;

        while (end >= 0 && s.charAt(end) == ' ') {
            end--;
        }

        int start = end;
        while (start >= 0 && s.charAt(start) != ' ') {
            start--;
        }

        System.out.println(end - start);
        sc.close();
    }
}
