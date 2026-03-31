package lexicaltwist;

import java.util.*;

public class LexicalTwist {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the first word");
        String first = sc.nextLine();

        //Validation for first word
        if (first.trim().contains(" ")) {
            System.out.println(first + " is an invalid word");
            return;
        }

        System.out.println("Enter the second word");
        String second = sc.nextLine();

        //Validation for second word
        if (second.trim().contains(" ")) {
            System.out.println(second + " is an invalid word");
            return;
        }

        //Check if second is reverse of first 
        String revFirst = new StringBuilder(first).reverse().toString();

        if (revFirst.equalsIgnoreCase(second)) {
           
            String transformed = revFirst.toLowerCase();
            transformed = transformed.replaceAll("[aeiou]", "@");
            System.out.println(transformed);

        } 
        else {
        

            String combined = (first + second).toUpperCase();

            int vowels = 0, consonants = 0;
            String vowelList = "";
            String consonantList = "";

            for (char ch : combined.toCharArray()) {
                if (ch >= 'A' && ch <= 'Z') 
                {
                    if ("AEIOU".indexOf(ch) != -1) 
                    {
                        vowels++;
                        if (!vowelList.contains(String.valueOf(ch)))
                            vowelList += ch;
                    } 
                    else
                    {
                        consonants++;
                        if (!consonantList.contains(String.valueOf(ch)))
                            consonantList += ch;
                    }
                }
            }

            if (vowels > consonants)
            {
                System.out.println(vowelList.substring(0, Math.min(2, vowelList.length())));
            } 
            else if (consonants > vowels)
            {
                System.out.println(consonantList.substring(0, Math.min(2, consonantList.length())));
            } 
            else 
            {
                System.out.println("Vowels and consonants are equal");
            }
        }
    }
}

