import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String t = sc.nextLine();

        if (s.length() != t.length()) {
            System.out.println(false);
            return;
        }

        int[] sarr = new int[26];
        int[] tarr = new int[26];

        for (int i = 0; i < s.length(); i++) {
            sarr[s.charAt(i) - 'a']++;
            tarr[t.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (sarr[i] != tarr[i]) {
                System.out.println(false);
                sc.close();
                return;
            }
        }

        System.out.println(true);
        sc.close();
    }
}
