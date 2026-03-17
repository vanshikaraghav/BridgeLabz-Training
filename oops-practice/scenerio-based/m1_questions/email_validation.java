package m1_questions;

import java.util.*;

public class email_validation {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        // Regex for validation
        String pattern = "^[a-z]{3,}\\.[a-z]{3,}\\d{4,}@(sales|marketing|IT|product)\\.company\\.com$";

        while(n-- > 0){
            String email = sc.nextLine();

            if(email.matches(pattern))
                System.out.println("Access Granted");
            else
                System.out.println("Access Denied");
        }
    }
}
