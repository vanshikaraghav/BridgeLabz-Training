package m1_questions;

import java.util.*;

public class keyGenerator {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        while(n-- > 0){

            String s = sc.nextLine();

            // Validation
            if(s.length() == 0){
                System.out.println("Invalid Input (empty string)");
                continue;
            }
            if(s.length() < 6){
                System.out.println("Invalid Input (length < 6)");
                continue;
            }
            if(s.contains(" ")){
                System.out.println("Invalid Input (contains space)");
                continue;
            }
            if(!s.matches("[a-zA-Z]+")){
                if(s.matches(".*\\d.*"))
                    System.out.println("Invalid Input (contains digits)");
                else
                    System.out.println("Invalid Input (contains special character)");
                continue;
            }

            // Step 1: lowercase
            s = s.toLowerCase();

            // Step 2: remove even ASCII chars
            StringBuilder sb = new StringBuilder();
            for(char c : s.toCharArray()){
                if(c % 2 != 0) sb.append(c);
            }

            // Step 3: reverse
            sb.reverse();

            // Step 4: uppercase even index
            for(int i=0;i<sb.length();i++){
                if(i % 2 == 0)
                    sb.setCharAt(i, Character.toUpperCase(sb.charAt(i)));
            }

            System.out.println("The generated key is - " + sb.toString());
        }
    }
}